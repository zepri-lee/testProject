package studio.thinkground.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import studio.thinkground.dto.UserDTO3;

@RestController
@RequestMapping(value="/api/v1/")
public class User2Controller  {
	
//	private final Logger LOGGER = LoggerFactory.getLogger(User2Controller.class);	

	@PostMapping(value="user2")
	public UserDTO3 userJson(@RequestBody UserDTO3 userDto3) throws JsonProcessingException {
		
		System.out.println("userDto3 : "+userDto3.toString());
		String requestMessage = null;

		ObjectMapper object = new ObjectMapper();
		requestMessage = object.writeValueAsString(userDto3);
		
		return userDto3ToObject(requestMessage);
	}
	
	public UserDTO3 userDto3ToObject(String requestMessage) throws JsonMappingException, JsonProcessingException {
		ObjectMapper object = new ObjectMapper();
		UserDTO3 userDto3 = object.readValue(requestMessage, UserDTO3.class);
		
		return userDto3;
	}
	
}
