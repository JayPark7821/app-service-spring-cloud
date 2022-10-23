package kr.perfume.commonmodule.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;

import kr.perfume.commonmodule.entity.user.User;
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
	private String userId;
	private String email;
	private String name;
	private ProviderType providerType;
	private RoleType roleType;
	private String profileImage;
	private String password;

	@Builder
	public UserDto(Long userSeq, String userId, String email, String name, ProviderType providerType, RoleType roleType, String profileImage, String password) {
		this.userSeq = userSeq;
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.providerType = providerType;
		this.roleType = roleType;
		this.profileImage = profileImage;
		this.password = password;
	}

	public User toEntity() {
		return User.builder()
			.userId(this.userId)
			.email(this.email)
			.emailVerifiedYn("Y")
			.providerType(this.providerType)
			.roleType(RoleType.USER)
			.password(this.password)
			.profileImageUrl(this.profileImage)
			.username(this.name)
			.build();
	}

}
