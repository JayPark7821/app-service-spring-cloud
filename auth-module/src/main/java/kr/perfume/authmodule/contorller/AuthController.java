package kr.perfume.authmodule.contorller;

import kr.perfume.authmodule.dto.response.SocialLoginResponseDto;
import kr.perfume.authmodule.service.AuthService;
import kr.perfume.commonmodule.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login/{provider}/{idToken}")
    public ResponseEntity<ApiResponse<SocialLoginResponseDto>> verifyIdToken(@PathVariable("provider") String providerType,
                                                                             @PathVariable("idToken") String idToken,
                                                                             HttpServletRequest request) throws UnknownHostException {

//        System.out.println("InetAddress.getByName() = " + InetAddress.getLocalHost().getCanonicalHostName());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(ApiResponse.success(authService.loginUserFromSocial(request, providerType, idToken)));

    }


}
