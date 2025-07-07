package echo.common;

import org.springframework.lang.Nullable;

public record Echo(String url, @Nullable Data data) {}
