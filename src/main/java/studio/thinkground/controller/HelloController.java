package studio.thinkground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value="hello")
	public String hello() {
		return "hello world";
	}	
	
	@GetMapping(value="hello/{no}")
	public String hello1(@PathVariable String no) {
		return no;
	}
	
	@GetMapping(value="hello1/{noNo}")
	public String hello2(@PathVariable("noNo") String no) {
		return no;
	}	
}
