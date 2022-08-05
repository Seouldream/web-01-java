package repository;

import models.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryTest {
  @Test
  void find() throws IOException {
    UsersRepository userRepository = new UsersRepository();
    List<User> users = List.of(
        new User("1234", "1234", "ashal")
    );

    assertEquals("1234", userRepository.find("1234").identifier());
    assertEquals("1234", userRepository.find("1234").password());
    assertEquals("ashal", userRepository.find("1234").name());
  }

  @Test
  void users() throws IOException {
    UsersRepository userRepository = new UsersRepository();

    assertEquals(2, userRepository.users().size());
    Map<String, User> users = userRepository.users();

    users.put("new", new User("new", "1234", "name"));
    assertEquals(3, users.size());
  }

  @Test
  void notFound() throws IOException {
    UsersRepository userRepository = new UsersRepository();

    assertEquals(2, userRepository.users().size());
    Map<String, User> users = userRepository.users();

    assertEquals("1234", userRepository.find("5678","1234").identifier());
   // assertEquals("1234", userRepository.find("5678").identifier());

  }
}
