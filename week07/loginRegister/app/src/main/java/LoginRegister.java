import com.sun.net.httpserver.*;

import models.*;
import org.checkerframework.checker.units.qual.*;
import pages.*;
import repository.*;
import utils.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class LoginRegister {
  private final FormParser formParser;
  private final AccountRepository accountRepository;
  private  AccountsLoader accountsLoader;

  public static void main(String[] args) throws IOException {
    LoginRegister application = new LoginRegister();
    application.run();
  }

  public LoginRegister() throws IOException {

    formParser = new FormParser();
    accountRepository = new AccountRepository();
    accountsLoader = new AccountsLoader();
  }

  private void run() throws IOException {

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      String method = exchange.getRequestMethod();

      String requestBody = new RequestBodyReader(exchange).body();
      System.out.println(requestBody);
      Map<String, String> formData = formParser.parse(requestBody);

      PageGenerator pageGenerator = process(path, method, formData);

      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);

    });

    System.out.println("http://localhost:8000");
    httpServer.start();


  }

  private PageGenerator process(String path, String method, Map<String, String> formData) throws IOException {
    return switch (path) {
      case "/login" -> processLogin(method, formData);
      case "/createAccount" -> processCreateAccount(method, formData);
      default -> new FrontPageGenerator();
    };
  }

  private PageGenerator processLogin(String method, Map<String, String> formData) {
    if (method.equals("GET")) {
      return new LoginPageGenerator();
    }
    return processLoginPost(formData);
  }

  private PageGenerator processLoginPost(Map<String, String> formData) {
    Account account = accountRepository.find(formData.get("identifier"), "test");
    if (!formData.get("identifier").equals(account.identifier())) {
      return new DoubleCheckIdentifierPageGenerator();
    }
    if (!formData.get("password").equals(account.password())) {
      return new PasswordMismatchFailPageGenerator();
    }
    return new SignedInPageGenerator(account);
  }

  private PageGenerator processCreateAccount(String method, Map<String, String> formData) throws IOException {
    if (method.equals("GET")) {
      return processCreateAccountGet();
    }

    return processCreateAccountPost(formData);
  }

  private CreateAccountPageGenerator processCreateAccountGet() {
    return new CreateAccountPageGenerator();
  }

  private PageGenerator processCreateAccountPost(Map<String, String> formData) throws IOException {

    AccountTester accountTester = new AccountTester(accountRepository);

    if (!accountTester.identifierTester(formData.get("identifier"))) {
      return new DuplicateIdentifierFailPageGenerator();
    }
    if (!accountTester.passwordTester(formData.get("password"),
        formData.get("passwordDoubleCheck"))) {
      return new PasswordMismatchFailPageGenerator();
    }
    if (formData.get("identifier") == null || formData.get("password") == null ||
        formData.get("name") == null || formData.get("passwordDoubleCheck") == null ||
        formData.get("email") == null) {
      return new EmptyContentFailPageGenerator();
    }

    accountRepository.accounts().put(formData.get("identifier"),
        new Account(
            formData.get("identifier"), formData.get("password"), formData.get("name"))
    );
    accountsLoader.save(accountRepository.accounts());
    return new CreateAccountSuccessPageGenerator();
  }
}
