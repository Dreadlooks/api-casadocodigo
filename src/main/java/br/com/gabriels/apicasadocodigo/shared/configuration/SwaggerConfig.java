package br.com.gabriels.apicasadocodigo.shared.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.gabriels.apicasadocodigo"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfos());
    }

    private ApiInfo apiInfos() {
        return new ApiInfoBuilder()
                .title("CDC Api")
                .description("Projeto criado para fornecer dados para a casa do codigo!")
                .version("1.0")
                .build();
    }
}
