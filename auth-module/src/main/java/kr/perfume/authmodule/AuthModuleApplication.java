package kr.perfume.authmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"kr.perfume.authmodule", "kr.perfume.commonmodule"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"kr.perfume.commonmodule","kr.perfume.authmodule"} )
//@EntityScan(basePackages = {"kr.perfume.commonmodule.entity"})
public class AuthModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthModuleApplication.class, args);
    }

}
