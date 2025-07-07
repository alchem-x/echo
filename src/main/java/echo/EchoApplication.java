package echo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class EchoApplication {

  @Bean
  public RestClient restClient() {
    return RestClient.create();
  }

  @Bean
  public ApplicationRunner echoRunner(EchoService service) {
    return (_) -> service.echo();
  }

  public static void main(String... args) {
    SpringApplication.run(EchoApplication.class, args);
  }
}
