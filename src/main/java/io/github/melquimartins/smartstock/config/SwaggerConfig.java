package io.github.melquimartins.smartstock.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configOpenAPI() {
        return new OpenAPI().info(new Info().title("Smart Stock").description(
                "Está API RESTful faz parte do projeto **Smart Stock**, um sistema de estoque inteligente de produtos."
        ));
    }

}
