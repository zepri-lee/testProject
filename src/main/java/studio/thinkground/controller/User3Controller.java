package studio.thinkground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.dto.UserDTO3;
import studio.thinkground.service.AbstractService;

@RestController
@RequestMapping(value="/api/v1/")
public class User3Controller extends AbstractService {
	
//	private final Logger LOGGER = LoggerFactory.getLogger(User2Controller.class);	
	
    @Autowired
    public void setRestTemplateBuilder(RestTemplateBuilder builder) {
        setRestTemplate(builder.build());
    }	

	@PostMapping(value="user3")
	public UserDTO3 userJson(@RequestBody UserDTO3 userDto3) {
		
		System.out.println("userDto3 : "+userDto3.toString());
		
		return restTemplate.postForObject("http://localhost:8080/api/v1/userRest", userDto3, UserDTO3.class);
		
	}
	
}
