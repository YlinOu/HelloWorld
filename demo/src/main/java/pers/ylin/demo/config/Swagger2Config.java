package pers.ylin.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("pers.ylin.demo"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .apiInfo(apiInfo());
    }

    private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("token", "token", "header"));
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot Demo Title")
                .description("Spring Boot Demo Description")
                .version("1.0")
                .build();
    }

}