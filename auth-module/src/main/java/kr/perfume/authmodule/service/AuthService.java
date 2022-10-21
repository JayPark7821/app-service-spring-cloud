package kr.perfume.authmodule.service;

import kr.perfume.authmodule.Repository.PreJoinUserRedisRepository;
import kr.perfume.authmodule.auth.verify.LocalVerifier;
import kr.perfume.commonmodule.client.UserServiceClient;
import kr.perfume.authmodule.dto.response.SocialLoginResponseDto;
import kr.perfume.authmodule.entity.PreJoinUser;
import kr.perfume.commonmodule.dto.response.UserResponseDto;
import kr.perfume.commonmodule.enums.ErrorCode;
import kr.perfume.commonmodule.enums.ProviderType;
import kr.perfume.authmodule.auth.userInfo.OAuth2UserInfo;
import kr.perfume.authmodule.auth.verify.GoogleVerifier;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final PreJoinUserRedisRepository preJoinUserRedisRepository;
    private final GoogleVerifier googleVerifier;
    private final LocalVerifier localVerifier;
    private final UserServiceClient userServiceClient;
    private final static String LOGIN = "login";
    private final static String JOIN = "join";

    @Transactional
    public SocialLoginResponseDto loginUserFromSocial(HttpServletRequest request, String providerType, String idToken) {
        ProviderType provider = ProviderType.of(providerType);
        OAuth2UserInfo userInfo = verifyToken(provider, idToken);
        UserResponseDto savedUser = userServiceClient.getUserByEmail(userInfo.getEmail()).getData();

        if (checkJoinOrLogin(savedUser, provider).equals(LOGIN)) {
            return genLoginUserDto(request, savedUser);
        } else {

            PreJoinUser preJoinUser = savePreJoinUser(userInfo, provider);
            return new SocialLoginResponseDto(preJoinUser);
        }
    }

    private PreJoinUser savePreJoinUser(OAuth2UserInfo userInfo, ProviderType providerType) {
        LocalDateTime now = LocalDateTime.now();
        String uuid = UUID.randomUUID().toString();
        return preJoinUserRedisRepository.savePreJoinUser(new PreJoinUser(userInfo, providerType, uuid));
    }

    private SocialLoginResponseDto genLoginUserDto(HttpServletRequest request, UserResponseDto savedUser) {
        String accessToken = "access-abcdefg";
        String refreshToken = "refresh-abcdefg";

        return new SocialLoginResponseDto(savedUser, accessToken, refreshToken);

    }

    private String checkJoinOrLogin(UserResponseDto userInfo, ProviderType providerType) {

        if (userInfo != null) {
            if (providerType != userInfo.getProviderType()) {
                throw new PerfumeApplicationException(HttpStatus.BAD_REQUEST,
                        "Looks like you're signed up with " + providerType +
                                " account. Please use your " + userInfo.getProviderType() + " account to login."
                );
            }
            return LOGIN;
        } else {
            return JOIN;
        }
    }

    private OAuth2UserInfo verifyToken(ProviderType provider, String token) {
        switch (provider) {
            case GOOGLE:
                return googleVerifier.verifyTdToken(token);
            case APPLE:
                throw new PerfumeApplicationException(ErrorCode.NOT_AVAILABLE_YET);
            case LOCAL:
                return localVerifier.verifyTdToken(token);
            default:
                throw new PerfumeApplicationException(ErrorCode.INVALID_PROVIDER_TYPE);
        }
    }

}
