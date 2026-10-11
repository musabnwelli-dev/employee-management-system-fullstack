package net.java.employee_management_system_fullstack;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
/**
 * Main class that starts the Spring Boot application.
 */

@SpringBootApplication
public class EmployeeManagementSystemFullstackApplication {


	/**
	 * Creates a ModelMapper bean for object mapping.
	 * @return ModelMapper instance
	 */
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

	/**
	 * Starts the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemFullstackApplication.class, args);
	}

}
