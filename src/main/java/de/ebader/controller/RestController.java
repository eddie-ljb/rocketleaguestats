package de.ebader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestController {
	
	@GetMapping
	public String hello() {
		return "Hallo Welt";
	}
	

}
