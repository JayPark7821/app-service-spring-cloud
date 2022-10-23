package kr.perfume.authmodule.contorller;

import kr.perfume.authmodule.dto.request.JoinRequestDto;
import kr.perfume.commonmodule.dto.SocialLoginResponseDto;
import kr.perfume.authmodule.service.AuthService;
import kr.perfume.commonmodule.dto.ApiResponse;
import kr.perfume.commonmodule.exception.PerfumeApplicationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@GetMapping("/login/{provider}/{idToken}")
	public ResponseEntity<ApiResponse<SocialLoginResponseDto>> verifyIdToken(
		@PathVariable("provider") String providerType,
		@PathVariable("idToken") String idToken,
		HttpServletRequest request) {

		return ResponseEntity.status(HttpStatus.ACCEPTED)
			.body(ApiResponse.success(authService.loginUserFromSocial(request, providerType, idToken)));
	}

	@PostMapping("/join")
	public ResponseEntity<ApiResponse<SocialLoginResponseDto>> join(@RequestBody @Valid JoinRequestDto requestDto,
		BindingResult bindingResult, HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			log.error("---------------------- JOIN USER BINDING ERROR --------------------------");
			for (ObjectError allError : bindingResult.getAllErrors()) {
				throw new PerfumeApplicationException(HttpStatus.BAD_REQUEST, allError.getDefaultMessage());
			}
		}
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(ApiResponse.created(authService.join(requestDto, request)));
	}
}
