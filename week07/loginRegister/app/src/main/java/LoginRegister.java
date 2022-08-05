import com.sun.net.httpserver.*;

import models.*;
import pages.*;
import repository.*;
import services.*;
import utils.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class LoginRegister {
  private final FormParser formParser;
  private final UsersRepository usersRepository;
  private UsersLoader usersLoader;

  public static void main(String[] args) throws IOException {
    LoginRegister application = new LoginRegister();
    application.run();
  }

  public LoginRegister() throws IOException {

    formParser = new FormParser();
    usersRepository = new UsersRepository();
    usersLoader = new UsersLoader();
  }

  private void run() throws IOException {

    InetSocketAddress address = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(address, 0);

    httpServer.createContext("/", exchange -> {
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();
      String method = exchange.getRequestMethod();

      String requestBody = new RequestBodyReader(exchange).body();

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
      case "/createUser" -> processCreateUser(method, formData);
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
    LoginTester loginTester = new LoginTester(usersRepository,formData);

    if (!loginTester.UserIdTester()) {
      return new DoubleCheckIdentifierPageGenerator();
    }
    if (!loginTester.UserPasswordTester()) {
      return new PasswordMismatchFailPageGenerator();
    }
    User user = usersRepository.find(formData.get("identifier"), "test");
    return new SignedInPageGenerator(user);
  }

  private PageGenerator processCreateUser(String method, Map<String, String> formData) throws IOException {
    if (method.equals("GET")) {
      return processCreateUserGet();
    }

    return processCreateUserPost(formData);
  }

  private CreateUserPageGenerator processCreateUserGet() {
    return new CreateUserPageGenerator();
  }

  private PageGenerator processCreateUserPost(Map<String, String> formData) throws IOException {

    UserCreationTester userCreationTester = new UserCreationTester(usersRepository);

    if (!userCreationTester.emptyTester(formData.get("identifier"),
        formData.get("password"),
        formData.get("passwordDoubleCheck"),
        formData.get("name"),
        formData.get("email"))) {
      return new EmptyContentFailPageGenerator();
    }

    if (!userCreationTester.passwordTester(formData.get("password"),
        formData.get("passwordDoubleCheck"))) {
      return new PasswordMismatchFailPageGenerator();
    }

    if (!userCreationTester.identifierTester(formData.get("identifier"))) {
      return new DuplicateIdentifierFailPageGenerator();
    }

    usersRepository.users().put(formData.get("identifier"),
        new User(formData.get("identifier"),
            formData.get("password"),
            formData.get("name"))
    );
    usersLoader.save(usersRepository.users());
    return new CreateUserSuccessPageGenerator();
  }
}
