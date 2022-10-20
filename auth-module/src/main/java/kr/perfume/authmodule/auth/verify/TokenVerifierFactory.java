package kr.perfume.authmodule.auth.verify;

import kr.perfume.authmodule.auth.userInfo.OAuth2UserInfo;

import java.io.IOException;
import java.security.GeneralSecurityException;


public interface TokenVerifierFactory {
	OAuth2UserInfo verifyTdToken(String token) throws GeneralSecurityException, IOException;
}
