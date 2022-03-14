package org.aasensio.exP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ExPApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExPApplication.class, args);
	}

}
