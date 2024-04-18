package studio.thinkground.controller;

import java.io.StringReader;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import studio.thinkground.dto.UserDTO;

@RestController
@RequestMapping(value="/api/v1/")
public class UserController  {
	
	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);	

	@PostMapping(value="user")
	public UserDTO userXml(@RequestBody UserDTO userDto) throws JAXBException {
		
		LOGGER.info("userDto : "+userDto.toString());
		System.out.println("userDto : "+userDto.toString());
		String requestMessage = null;

		JAXBContext jaxbContext = JAXBContext.newInstance(UserDTO.class);
	
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		
		StringWriter writer = new StringWriter();
		jaxbMarshaller.marshal(userDto, writer);
		
		requestMessage = writer.toString();
		System.out.println("requestMessage : "+requestMessage);			
		return UserDtoUnmarshall(requestMessage);
	}	
	
	public UserDTO UserDtoUnmarshall(String requestMessage) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(UserDTO.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		UserDTO userDto = (UserDTO)jaxbUnmarshaller.unmarshal(new StringReader(requestMessage));
		
		return userDto;
	}
	
}
