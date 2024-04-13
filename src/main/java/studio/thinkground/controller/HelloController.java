package studio.thinkground.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.common.util.StringUtils;
import studio.thinkground.dto.MemberDTO;

@RestController
@RequestMapping(value="/api/v1/")
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
	
	@GetMapping(value="hello2")
	public String hello2(@RequestParam String name
			           , @RequestParam String email
			           , @RequestParam String organization) {
		if(StringUtils.isEmpty(name)) {
			return "name is empty";			
		}
		if(StringUtils.isEmpty(organization)) {
			return "organization is empty";			
		}

		return name + "/" + email + "/" + organization;
	}	
	
	@GetMapping(value="hello3")
	public String hello3(@RequestParam Map<String, Object> param) {
		StringBuilder sb = new StringBuilder();
		
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + ":" + map.getValue() + "\n");
		});
		
		return sb.toString();
	}	
	
	@GetMapping(value="hello4")
	public String hello4(MemberDTO member) {
		
		return member.getName() + " / " + member.getEmail() + " / " + member.getOrganization();
	}	
}
