package utils;

import models.*;

import java.io.*;
import java.util.*;

public class UsersLoader {
  public Map<String, User> load() throws FileNotFoundException {
    Map<String, User> users = new HashMap<>();

    File file = new File("usersList.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      User account = parse(line);

      users.put(account.identifier(), account);
    }

    return users;
  }

  public User parse(String line) {
    String[] words = line.split(",");
    String identifier = words[0];
    String password = words[1];
    String name = words[2];
    return new User(identifier, password, name);
  }

  public void save(Map<String, User> users) throws IOException {
    FileWriter fileWriter = new FileWriter("usersList.csv");

    for (User account : users.values()) {
      String line = account.toCsvRow();
      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }
}
