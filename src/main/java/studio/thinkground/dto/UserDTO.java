package studio.thinkground.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="user")
public class UserDTO {
	private String name;
	private String email;
	private String organization;
	
	public String getName() {
		return name;
	}
	@XmlElement(name="name")
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	@XmlElement(name="email")
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrganization() {
		return organization;
	}
	@XmlElement(name="organization")
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", organization=" + organization + "]";
	}
}
