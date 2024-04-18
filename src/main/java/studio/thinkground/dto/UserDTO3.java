package studio.thinkground.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserDTO3 {
	@JsonProperty(value="user")
	private UserDTO2 user;

	public UserDTO2 getUser() {
		return user;
	}

	public void setUser(UserDTO2 user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDTO3 [user=" + user + "]";
	}
	

}
