package services;

import org.junit.jupiter.api.*;
import repository.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;

class LoginTesterTest {
  @Test
  void wrongIdTest() throws IOException {
    UsersRepository usersRepository = new UsersRepository();
    Map<String,String> formData = new HashMap<>();
    formData.put("identifier","inu");
    formData.put("password","123");// 아이디에 해당하는 폼데이터
    LoginTester loginTester = new LoginTester(usersRepository,formData);
    assertFalse(loginTester.UserIdTester());
  }

    @Test
    void rightIdTest() throws IOException {
      UsersRepository usersRepository = new UsersRepository();
      Map<String,String> formData = new HashMap<>();
      formData.put("identifier","test");
      formData.put("password","123");// 아이디에 해당하는 폼데이터
      LoginTester loginTester = new LoginTester(usersRepository,formData);
      assertTrue(loginTester.UserIdTester());
    }

}