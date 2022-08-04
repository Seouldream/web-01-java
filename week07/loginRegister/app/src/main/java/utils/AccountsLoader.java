package utils;

import models.*;

import java.io.*;
import java.util.*;

public class AccountsLoader {
  public Map<String, Account> load() throws FileNotFoundException {
    Map<String, Account> accounts = new HashMap<>();

    File file = new File("accountList.csv");

    Scanner scanner = new Scanner(file);

    while(scanner.hasNextLine()) {
      String line = scanner.nextLine();

      Account account = parse(line);

      accounts.put(account.identifier(), account);
    }

    return accounts;
  }

  public Account parse(String line) {
    String[] words = line.split(",");
    String identifier = words[0];
    String password = words[1];
    String name = words[2];
    return new Account(words[0], words[1], words[2]);
  }

  public void save(Map<String, Account> accounts) throws IOException {
    FileWriter fileWriter = new FileWriter("accountList.csv");

    for (Account account : accounts.values()) {
      String line = account.toCsvRow();
      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }
}
