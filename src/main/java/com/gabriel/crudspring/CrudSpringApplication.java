package com.gabriel.crudspring;

import com.gabriel.crudspring.enums.Category;
import com.gabriel.crudspring.model.Course;
import com.gabriel.crudspring.model.Lesson;
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

			Lesson l = new Lesson();
			l.setName("Introdução");
			l.setYoutubeUrl("aaaaaaaaaaa");
			l.setCourse(c1);
			c1.getLessons().add(l);

			Lesson l1 = new Lesson();
			l1.setName("Introdução 2");
			l1.setYoutubeUrl("bbbbbbbbbb");
			l1.setCourse(c1);
			c1.getLessons().add(l1);




			courseRepository.save(c1);
		};
	}

}
