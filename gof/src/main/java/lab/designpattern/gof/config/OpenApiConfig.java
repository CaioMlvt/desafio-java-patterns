package lab.designpattern.gof.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiDoc() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product API - Design Patterns")
                        .description("API criada para estudos de Spring Boot, JPA, Feign e Design Patterns.")
                        .version("1.0")
                );
    }
}