package echo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class EchoApplicationTests {

  @MockitoBean("echoRunner")
  ApplicationRunner echoRunner;

  @Test
  void contextLoads() {}
}
