package org.aasensio.asensioAlejandro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AsensioAlejandroApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsensioAlejandroApplication.class, args);
	}

}
