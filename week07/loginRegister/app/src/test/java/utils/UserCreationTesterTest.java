package utils;

import models.*;
import org.junit.jupiter.api.*;
import repository.*;
import services.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserCreationTesterTest {
  @Test
  void duplicateID() throws IOException {
    UsersRepository usersRepository = new UsersRepository();

    String id1 = "1234";
    String id2 = "5678";

    for(Map.Entry<String, User> account : usersRepository.users().entrySet()) {
      if(account.getKey().equals(id1)) {
        break;
      }
      usersRepository.users().put(id1,new User(id1,"password","name"));
    }

    assertEquals(2,usersRepository.users().size());
  }

  @Test
  void mismatchPassword() throws IOException {
    UsersRepository usersRepository = new UsersRepository();
    List<User> users = new ArrayList<>();
    users.add(new User("1234","abc","ashal"));
    users.add(new User("2345","def","joker"));

    String identifier = "test";
    String password = "test";
    String passwordDoubleCheck = "mismatch";
    String name = "jun";

    if(password.equals(passwordDoubleCheck)) {
      users.add(new User(identifier,password,name));
    }

    assertNull(usersRepository.find("test"));
  }

  @Test
  void emptyForm() throws IOException {
    UsersRepository usersRepository = new UsersRepository();
    UserCreationTester userCreationTester = new UserCreationTester(usersRepository);
    List<User> users = new ArrayList<>();
    users.add(new User("1234","abc","ashal"));
    users.add(new User("2345","def","joker"));

    String identifier = "test";
    String password = "test";
    String passwordDoubleCheck = "mismatch";
    String email = "";
    String name = "jun";


    assertTrue(userCreationTester.emptyTester(identifier,password,passwordDoubleCheck,email,name));
    assertEquals(3,usersRepository.users().size());
  }
}
