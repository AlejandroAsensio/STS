package org.aasensio.pap2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Pap2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Pap2022Application.class, args);
	}

}
