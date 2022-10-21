package kr.perfume.usermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"kr.perfume.usermodule", "kr.perfume.commonmodule"})
//@EntityScan("kr.perfume.commonmodule.entity")
@EnableDiscoveryClient
@EnableFeignClients
public class UserModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserModuleApplication.class, args);
	}

}
