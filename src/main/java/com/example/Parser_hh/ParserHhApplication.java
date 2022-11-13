package com.example.Parser_hh;

import com.example.Parser_hh.controller.Parse_Connect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParserHhApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParserHhApplication.class, args);
		Parse_Connect.startProg();
	}
}
