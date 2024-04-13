package studio.thinkground.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.dto.MemberDTO;

@RestController
@RequestMapping(value="/api/v1/")
public class PutController {
	
	@PutMapping(value="put")
	public String put(@RequestBody MemberDTO member) {
		
		return member.toString();
	}
	
	@PutMapping(value="put1")
	public MemberDTO put1(@RequestBody MemberDTO member) {
		
		return member;
	}	
	
	@PutMapping(value="put2")
	public ResponseEntity<MemberDTO> put2(@RequestBody MemberDTO member) {
		
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}	
}
