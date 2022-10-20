package kr.perfume.authmodule.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AuthService {
    public String loginUserFromSocial(HttpServletRequest request, String providerType, String idToken) {

        return "ok";
    }
}
