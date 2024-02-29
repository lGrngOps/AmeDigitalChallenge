/**
package com.grngenterprise.amedigitalchallenge.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class SwaggerConfig {

 @Bean
 public GroupedOpenApi openApi(){
 return GroupedOpenApi.builder()
          .group("amedigitalchallenge-public")
          .pathsToMatch("/public/**")
          .build();
 }

 @Bean
 public OpenAPI openAPI(){
  return new OpenAPI()
          .info(new Info().title("")
                  .description("")
                  .version("")
                  .license(new License().name("").url("")))
          .externalDocs(new ExternalDocumentation()
                  .description("")
                  .url(""));
 }

  private Contact contato(){
  return new Contact(
  "Desafio AmeDigital",
  "https://github.com/lGrngOps/AmeDigitalChallenge",
  "GrngOps@teste.com.br");
  }
  private ApiInfoBuilder infoBuilder() {

  ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

  apiInfoBuilder.title("Desafio AmeDigital");
  apiInfoBuilder.description("Documentação gerada via Swagger");
  apiInfoBuilder.version("1.0");
  apiInfoBuilder.termsOfServiceUrl("Termo de Uso: Open Source");
  apiInfoBuilder.license("Licenciado GrngoEnterprise");
  apiInfoBuilder.licenseUrl("https://github.com/lGrngOps/AmeDigitalChallenge");
  apiInfoBuilder.contact(this.contato());

  return apiInfoBuilder;
  }

  @Bean
  public Docket detailApi(){
  Docket docket = new Docket(DocumentationType.SWAGGER_2);

  docket
  .select()
  .apis(RequestHandlerSelectors.basePackage("com.grngenterprise.amedigitalchallenge.controllers"))
  .paths(PathSelectors.any())
  .build()
  .apiInfo(this.infoBuilder().build())
  .consumes(new HashSet<String>(Arrays.asList("application/json")))
  .produces(new HashSet<String>(Arrays.asList("application/json")));

  return docket;
  }
}
**/