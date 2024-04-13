package studio.thinkground.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/")
public class DeleteController {
	
	@DeleteMapping(value="delete/{variable}")
	public String delete(@PathVariable String variable) {
		
		return variable;
	}	
}
