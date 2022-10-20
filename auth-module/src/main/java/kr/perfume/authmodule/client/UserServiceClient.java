package kr.perfume.authmodule.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.perfume.commonmodule.dto.response.UserResponseDto;

@FeignClient(name = "user-module")
public interface UserServiceClient {
	@GetMapping("/user-service/api/v1/user/{userId}")
	UserResponseDto getUser(@PathVariable("userId")String userId);

}
