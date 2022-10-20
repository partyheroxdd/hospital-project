package kz.iitu.itis1908.hospitalmanagementservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(
            new Info().title("Miras Azhar API").description("Hospital management system application")
                .version("v0.0.1"))
        .externalDocs(new ExternalDocumentation().description("Hospital service Documentation"));
  }
}
