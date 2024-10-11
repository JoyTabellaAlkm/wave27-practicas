package com.sprint1.be_java_hisp_w27_g04;

import com.sprint1.be_java_hisp_w27_g04.repository.impl.UserRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BeJavaHispW27G04Application {

	public static void main(String[] args) throws IOException {
		UserRepositoryImpl repository = new UserRepositoryImpl();
		SpringApplication.run(BeJavaHispW27G04Application.class, args);
	}
}
