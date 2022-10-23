package kr.perfume.commonmodule.dto.auth;

import kr.perfume.commonmodule.dto.user.UserDto;
import kr.perfume.commonmodule.enums.ProviderType;
import kr.perfume.commonmodule.enums.RoleType;
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


    public SocialLoginResponseDto(UserDto user, String accessToken, String refreshToken) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
        this.providerType = user.getProviderType();
        this.roleType = user.getRoleType();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }


    public SocialLoginResponseDto(String tempUserId, String email, String name, ProviderType providerType,
        String profileImage ) {
        this.tempUserId = tempUserId;
        this.email = email;
        this.name = name;
        this.providerType = providerType;
        this.profileImage = profileImage;
    }
}
