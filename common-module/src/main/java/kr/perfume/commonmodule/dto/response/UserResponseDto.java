package kr.perfume.commonmodule.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto {

	private Long userSeq;
	private String email;
	private String name;

	@Builder
	public UserResponseDto(Long userSeq, String email, String name) {
		this.userSeq = userSeq;
		this.email = email;
		this.name = name;
	}
}
