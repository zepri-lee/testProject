package studio.thinkground.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserDTO2 {
	@JsonProperty(value="name")
	private String name;
	@JsonProperty(value="email")
	private String email;
	@JsonProperty(value="organization")
	private String organization;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", organization=" + organization + "]";
	}
}
