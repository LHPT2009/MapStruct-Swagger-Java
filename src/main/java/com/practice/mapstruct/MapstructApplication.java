package com.practice.mapstruct;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MapstructApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapstructApplication.class, args);
	}

	@Bean
	public OpenAPI openApiConfig(){
		return new OpenAPI().info(apiInfo());
	}

	public Info apiInfo(){
		Info info = new Info();
		info
				.title("Demo use Swagger by Phương Tùng")
				.description("Live Code System Swagger Open API")
				.version("v1.0.0");
		return info;
	}
}
