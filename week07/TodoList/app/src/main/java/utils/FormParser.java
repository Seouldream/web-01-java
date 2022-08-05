package utils;

public class FormParser {
  public String parse(String requestBody) {
    String[] pair = requestBody.split("=");
    if (pair.length == 2) {
      return pair[1];
    }
    return "";
  }
}
