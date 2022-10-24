package kr.perfume.authmodule.auth.verify;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import kr.perfume.authmodule.auth.userInfo.OAuth2UserInfo;
import kr.perfume.authmodule.dto.response.ApplePublicKeyResponse;
import kr.perfume.authmodule.service.AppleClient;
import kr.perfume.commonmodule.enums.ErrorCode;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.*;

@Component
@RequiredArgsConstructor
public class AppleVerifier implements TokenVerifierFactory {

    private final AppleClient appleClient;

    @Override
    public OAuth2UserInfo verifyTdToken(String token) {

        Map<String, String> header = getHeader(token.substring(0, token.indexOf(".")));

        ApplePublicKeyResponse.Key key = appleClient.getAppleAuthPublicKey()
                .getMatchedKeyBy(header.get("kid"), header.get("alg"))
                .orElseThrow(() -> new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR));

        Claims body = getBodyFromToken(token, key);
        return null;
    }

    private static Claims getBodyFromToken(String token, ApplePublicKeyResponse.Key key) {
        try {
            RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(new BigInteger(1, Base64.getUrlDecoder().decode(key.getN())),
                    new BigInteger(1, Base64.getUrlDecoder().decode(key.getE())));

            PublicKey publicKey = KeyFactory.getInstance(key.getKty()).generatePublic(publicKeySpec);

            return Jwts.parserBuilder()
                    .setSigningKey(publicKey).build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private static Map<String, String> getHeader(String headerOfIdentityToken) {
        try {
            return new ObjectMapper().readValue(new String(Base64.getDecoder().decode(headerOfIdentityToken), "UTF-8"), Map.class);
        } catch (Exception e) {
            throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
