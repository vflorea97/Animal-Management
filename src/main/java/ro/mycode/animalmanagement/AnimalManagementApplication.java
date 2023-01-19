package ro.mycode.animalmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.animalmanagement.view.View;

@SpringBootApplication
public class AnimalManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(View view) {
		return args -> {

			view.play();
		};
	}
}
