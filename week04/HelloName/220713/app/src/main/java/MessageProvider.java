public class MessageProvider {
  private String name;
  public MessageProvider() {
    name = "world";
  }

  public MessageProvider(String name) {
    this.name = name;
  }

  public String greetingMessage() {
    return "Hello, " + name + "!";

  }
}
