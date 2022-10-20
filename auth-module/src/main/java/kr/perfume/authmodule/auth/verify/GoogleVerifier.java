package kr.perfume.authmodule.auth.verify;


import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;

import kr.perfume.authmodule.auth.userInfo.GoogleOAuth2UserInfo;
import kr.perfume.authmodule.auth.userInfo.OAuth2UserInfo;
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
public class GoogleVerifier implements TokenVerifierFactory {
    @Value("${google.clientId}")
    private String clientId;
    private final NetHttpTransport transport = new NetHttpTransport();
    private final JsonFactory jsonFactory = new GsonFactory();

    @Override
    public OAuth2UserInfo verifyTdToken(String token) {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setIssuers(Arrays.asList("https://accounts.google.com", "accounts.google.com"))
                .setAudience(Collections.singletonList(clientId))
                .build();

        GoogleIdToken idToken = null;
        try {
            idToken = verifier.verify(token);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();
            Map<String, Object> attributes = new HashMap<String, Object>();
            attributes.put("id", payload.getSubject());
            attributes.put("name", payload.get("name"));
            attributes.put("email", payload.get("email"));
            attributes.put("picture", payload.get("picture"));
            return new GoogleOAuth2UserInfo(attributes);

        } else {
            throw new IllegalArgumentException("Invalid ID token");
        }
    }
}
