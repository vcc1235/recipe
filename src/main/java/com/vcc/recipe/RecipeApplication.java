package com.vcc.recipe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.vcc.recipe.**.mapper")
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}
}

