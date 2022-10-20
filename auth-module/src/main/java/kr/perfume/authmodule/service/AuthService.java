package kr.perfume.authmodule.service;

import kr.perfume.commonmodule.enums.ProviderType;
import kr.perfume.authmodule.auth.userInfo.OAuth2UserInfo;
import kr.perfume.authmodule.auth.verify.GoogleVerifier;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

	private final GoogleVerifier googleVerifier;

	@Transactional
	public String loginUserFromSocial(HttpServletRequest request, String providerType, String idToken) {
		ProviderType provider = ProviderType.of(providerType);
		OAuth2UserInfo userInfo = verifyToken(provider, idToken);


		return "ok";
	}

	private OAuth2UserInfo verifyToken(ProviderType provider, String token) {
		switch (provider) {
			case GOOGLE:
				return googleVerifier.verifyTdToken(token);
			case APPLE:
				throw new IllegalArgumentException("준비중 입니다");
			default:
				throw new IllegalArgumentException("Invalid Provider Type");
		}
	}

}
