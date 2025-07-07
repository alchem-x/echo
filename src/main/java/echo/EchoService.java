package echo;

import echo.common.Data;
import echo.common.Echo;
import echo.common.YamlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestClient;

@Service
public class EchoService {

  private static final Logger log = LoggerFactory.getLogger(EchoService.class);

  private final RestClient restClient;

  public EchoService(RestClient restClient) {
    this.restClient = restClient;
  }

  public void echo() {
    log.info("Echo Started");
    this.echoGet();
    this.echoPost();
    log.info("Echo Done");
  }

  private void echoGet() {
    var r = this.restClient.get().uri("https://postman-echo.com/get").retrieve().body(Echo.class);
    Assert.notNull(r, "r is null");
    Assert.isNull(r.data(), "X get data");
  }

  private void echoPost() {
    var data = YamlUtils.readYaml("data.yaml", Data.class);
    var r = this.restClient.post().uri("https://postman-echo.com/post").body(data).retrieve().body(Echo.class);
    Assert.notNull(r, "r is null");
    Assert.notNull(r.data(), "r.data is null");
    Assert.state("hello world".equals(r.data().value()), "X post data");
  }
}
