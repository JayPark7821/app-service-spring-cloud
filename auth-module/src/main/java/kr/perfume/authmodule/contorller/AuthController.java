package kr.perfume.authmodule.contorller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login/{provider}/{idToken}")
    public void verifyIdToken(@PathVariable("provider") String providerType,
                              @PathVariable("idToken") String idToken,
                              HttpServletRequest request) {
        ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(authService.loginUserFromSocial(request, providerType, idToken));

    }


}
