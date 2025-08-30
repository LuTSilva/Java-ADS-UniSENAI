package com.superior.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PooApplication {

	public static void main(String[] args) {
		SpringApplication.run(PooApplication.class, args);
	}

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/info")
    public String info(){
        return "Você pode utilizar: /hello";
    }
}
