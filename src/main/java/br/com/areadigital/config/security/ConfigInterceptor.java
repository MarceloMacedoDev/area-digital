package br.com.areadigital.config.security;

import br.com.areadigital.operation.observability.Observability;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class ConfigInterceptor implements WebMvcConfigurer {

    private final Observability inperceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(inperceptor);
    }
}