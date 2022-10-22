package kr.perfume.authmodule.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JoinRequestDto {

	@Valid
	@NotNull(message = "임시 유저ID는 필수 값입니다.")
	private String tempUserId;

	@Valid
	@NotNull(message = "사용자 이름은 필수 값입니다.")
	@Size(min=1,max =100)
	private String name;

	@Valid
	@NotNull(message = "사용자 email은 필수 값입니다.")
	@Size(max = 512)
	@Email
	private String email;
}
