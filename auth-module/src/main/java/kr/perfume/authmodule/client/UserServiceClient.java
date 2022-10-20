package kr.perfume.authmodule.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-module")
public interface UserServiceClient {

	@GetMapping("/user-service/{userId}")
	void getUser(@PathVariable("userId")String userId);

}
