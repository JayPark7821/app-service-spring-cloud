package kr.perfume.commonmodule.client;

import kr.perfume.commonmodule.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.perfume.commonmodule.dto.UserDto;

@FeignClient(name = "user-service")
public interface UserServiceClient {
	@GetMapping("/api/v1/user/{email}")
	ApiResponse<UserDto> getUserByEmail(@PathVariable("email")String email);

}
