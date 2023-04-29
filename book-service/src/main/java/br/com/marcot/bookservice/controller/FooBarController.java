package br.com.marcot.bookservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Foo bar")
@RestController
@RequestMapping("book-service")
public class FooBarController {
	
	
	@Operation(summary = "Foo bar")
	@GetMapping("/foo-bar")
	public String fooBar() {
		new RestTemplate()
		     .getForEntity("http://localhost:8080/foo-bar", String.class);
		return "Foo-Bar!!!";
	}

}
