package kr.perfume.authmodule.dto.response;

import kr.perfume.authmodule.entity.PreJoinUser;
import kr.perfume.commonmodule.dto.response.UserResponseDto;
import kr.perfume.commonmodule.enums.ProviderType;
import kr.perfume.commonmodule.enums.RoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SocialLoginResponseDto {

    private String tempUserId;
    private String email;
    private String name;
    private ProviderType providerType;
    private RoleType roleType;
    private String profileImage;
    private String accessToken;
    private String refreshToken;

    @Builder
    public SocialLoginResponseDto(UserResponseDto user, String accessToken, String refreshToken) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
        this.providerType = user.getProviderType();
        this.roleType = user.getRoleType();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public SocialLoginResponseDto(PreJoinUser preJoinUser) {
        this.tempUserId = preJoinUser.getUserUuid();
        this.email = preJoinUser.getEmail();
        this.name = preJoinUser.getUsername();
        this.profileImage = preJoinUser.getProfileImageUrl();
        this.providerType = preJoinUser.getProviderType();
    }

}
