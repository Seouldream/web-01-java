import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {
  @Test
  void defaultMessage() {

    MessageProvider messageProvider = new MessageProvider();

    assertEquals("Hello, world!",messageProvider.greetingMessage());
  }

  @Test
  void message() {
    String name = "hoon";
    MessageProvider messageProvider = new MessageProvider(name);

    assertEquals("Hello, hoon!",messageProvider.greetingMessage());
  }

}