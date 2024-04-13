package studio.thinkground.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor // 기본 생성자 생성
//@RequiredArgsConstructor // NonNull이 붙은 필드의 생성
@AllArgsConstructor // 모든 필드의 생성자 생성
@Getter // getter
@Setter // setter
@ToString // ToString
public class MemberDTO {
	private String name;
	private String email;
	private String organization;
}
