package studio.thinkground.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.dto.MemberDTO;

@RestController
@RequestMapping(value="/api/v1/")
public class PostController {
	
	@PostMapping(value="post")
	public String post(@RequestBody Map<String, Object> param) {
		StringBuilder sb = new StringBuilder();
		
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}	
	
	@PostMapping(value="post2")
	public String post2(@RequestBody MemberDTO member) {
		
		return member.toString();
	}		
}
