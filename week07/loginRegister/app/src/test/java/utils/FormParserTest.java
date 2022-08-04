package utils;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.*;

import static org.junit.jupiter.api.Assertions.*;

class FormParserTest {
  @Test
  void parse() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("&identifier=1234&password=1000" +
        "&passwordDoubleCheck=1000");

    assertEquals("1234", formData.get("identifier"));
    assertEquals("1000", formData.get("password"));
    assertEquals("1000", formData.get("passwordDoubleCheck"));
  }

  @Test
  void parseWithBlank() {
    FormParser formParser = new FormParser();

    Map<String, String> formData = formParser.parse("");

    assertFalse(formData.containsKey("to"));
  }
}