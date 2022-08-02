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
  private AccountRepository accountRepository = new AccountRepository();
  public static void main(String[] args) throws IOException {
    LoginRegister application = new LoginRegister();
    application.run();
  }

  private void run() throws IOException {

    File file = new File("accountList.csv");

    Scanner scanner = new Scanner(file);
    while(scanner.hasNextLine()) {
      String[] accountInfo = scanner.nextLine().split("::");
      accountRepository.accounts().add(new Account(accountInfo[0],accountInfo[1],accountInfo[2]));
    }

    InetSocketAddress addrress = new InetSocketAddress(8000);
    HttpServer httpServer = HttpServer.create(addrress,0);

    httpServer.createContext("/",exchange -> {
      URI requestURI = exchange.getRequestURI();
      String path = requestURI.getPath();

      PageGenerator pageGenerator = new FrontPageGenerator();
      if(path.equals("/login")) {
        pageGenerator = new LoginPageGenerator();
      }
      if(path.equals("/createAccount")) {
        pageGenerator = new CreateAccountPageGenerator();
      }


      String content = pageGenerator.html();

      MessageWriter messageWriter = new MessageWriter(exchange);
      messageWriter.write(content);

    });

    System.out.println("http://localhost:8000");
    httpServer.start();
  }
}
