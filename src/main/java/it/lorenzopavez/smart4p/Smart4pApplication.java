package it.lorenzopavez.smart4p;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = { "it.lorenzopavez.smart4p" })
public class Smart4pApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Smart4pApplication.class); 

	}

	public static void main(String[] args) {
		SpringApplication.run(Smart4pApplication.class, args);
	}

}
