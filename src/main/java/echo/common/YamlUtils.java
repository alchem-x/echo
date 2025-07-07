package echo.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.io.UncheckedIOException;
import org.springframework.core.io.ClassPathResource;

public abstract class YamlUtils {

  public static <T> T readYaml(String path, Class<T> clazz) {
    try {
      return new ObjectMapper(new YAMLFactory()).readValue(new ClassPathResource(path).getInputStream(), clazz);
    } catch (IOException ex) {
      throw new UncheckedIOException("read yaml failed", ex);
    }
  }
}
