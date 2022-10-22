package kr.perfume.commonmodule.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import kr.perfume.commonmodule.enums.ProviderType;
import kr.perfume.commonmodule.enums.RoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

	private Long userSeq;
	private String email;
	private String name;
	private ProviderType providerType;
	private RoleType roleType;
	private String profileImage;

	@Builder
	public UserDto(Long userSeq, String email, String name, ProviderType providerType, RoleType roleType, String profileImage) {
		this.userSeq = userSeq;
		this.email = email;
		this.name = name;
		this.providerType = providerType;
		this.roleType = roleType;
		this.profileImage = profileImage;
	}
}
