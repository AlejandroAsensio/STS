package org.aasensio.pruebaExamen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoExApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoExApplication.class, args);
	}

}
