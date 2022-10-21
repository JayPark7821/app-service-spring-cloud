package kr.perfume.authmodule.auth.verify;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import kr.perfume.authmodule.auth.userInfo.GoogleOAuth2UserInfo;
import kr.perfume.authmodule.auth.userInfo.LocalUserInfo;
import kr.perfume.authmodule.auth.userInfo.OAuth2UserInfo;
import kr.perfume.commonmodule.enums.ErrorCode;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class LocalVerifier implements TokenVerifierFactory {


    @Override
    public OAuth2UserInfo verifyTdToken(String token) {

        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("id", "testId");
        attributes.put("name", "테스트 유저");
        attributes.put("email", "test@test.com");
        attributes.put("picture", "testUrl");
        return new LocalUserInfo(attributes);

    }
}
