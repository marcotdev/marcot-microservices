package br.com.marcot.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class GreetingConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingConfigServerApplication.class, args);
	}

}
