package com.lecturespringintro;

import com.lecturespringintro.entities.Animal;
import com.lecturespringintro.entities.Dog;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringIntroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntroApplication.class, args);
	}

	@Scope("prototype")//Всеки път ще ни връща нова инстанция, по default е Singleton(идват пр.3 request-a и всеки от тех достъпва едно и също (куче в случая), а когато е "prototype"всеки request ще достъпва различно куче.
	@Bean
	public Animal getDog(){
		return new Dog();
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
