package com.example.Parser_hh;

import com.example.Parser_hh.controller.Parse_Connect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParserHhApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParserHhApplication.class, args);
		try {
			Parse_Connect.startConnectForParse();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


//	@GetMapping("/hello")
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		String urlGif = "";
//		try {
//			urlGif = CurrencyParser.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//return "<div style = 'width:300px', align=center><img src='"+urlGif+"'></div>";
	//}

}
