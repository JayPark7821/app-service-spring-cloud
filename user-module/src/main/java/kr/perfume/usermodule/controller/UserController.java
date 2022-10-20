package kr.perfume.usermodule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.perfume.commonmodule.dto.response.UserResponseDto;
import kr.perfume.usermodule.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

	private final UserService userService;

	@GetMapping("/user/{userId}")
	public ResponseEntity<UserResponseDto> getUser(@PathVariable("userId") Long userId) {
		return ResponseEntity.status(HttpStatus.OK)
			.body(userService.getUser(userId));
	}
}
