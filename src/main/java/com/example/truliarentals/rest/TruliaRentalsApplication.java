package com.example.truliarentals.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.truliarentals"})
public class TruliaRentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruliaRentalsApplication.class, args);
	}
}
