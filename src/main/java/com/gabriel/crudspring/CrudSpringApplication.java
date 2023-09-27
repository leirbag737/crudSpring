package com.gabriel.crudspring;

import com.gabriel.crudspring.enums.Category;
import com.gabriel.crudspring.model.Course;
import com.gabriel.crudspring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();
			Course c1 = new Course();
			c1.setName("Angular com Spring");
			c1.setCategory(Category.FRONT_END);
			courseRepository.save(c1);
		};
	}

}
