package com.example.jwt.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI apiV1() {
        String title = "Sheee.Da API ";
        String version = "V1";

        Info info = new Info().title(title).version(version)
                .description("").termsOfService("").contact(null).license(null);

        return new OpenAPI().components(new Components()).info(info);
    }

    @Bean
    public OpenApiCustomiser apiV11() {
        SecurityScheme securityScheme = new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .bearerFormat("JWT")
                .scheme("bearer");

        return OpenApi -> OpenApi
                .addSecurityItem(new SecurityRequirement().addList("jwt token"))
                .getComponents().addSecuritySchemes("jwt token", securityScheme);
    }

    /*@Bean
    public GroupedOpenApi SecurityGroupOpenApi() {
        return GroupedOpenApi
                .builder()
                .group("Security Open Api")
                .pathsToExclude("/auth/*", "/")
                .addOpenApiCustomiser(buildSecurityOpenApi())
                .build();
    }

    @Bean
    public GroupedOpenApi NonSecurityGroupOpenApi() {
        return GroupedOpenApi
                .builder()
                .group("Non Security Open Api")
                .pathsToMatch("/auth/*")
                .build();
    }

    public OpenApiCustomiser buildSecurityOpenApi() {
        SecurityScheme securityScheme = new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .bearerFormat("JWT")
                .scheme("bearer");

        return OpenApi -> OpenApi
                .addSecurityItem(new SecurityRequirement().addList("jwt token"))
                .getComponents().addSecuritySchemes("jwt token", securityScheme);
    }*/

    /*@Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.jwt.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(apiKey()))
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Practice Swagger.")
                .description("practice swagger config.")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "jwt", "header");
    }*/
}