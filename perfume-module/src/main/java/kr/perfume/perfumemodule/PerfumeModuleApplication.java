package kr.perfume.perfumemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"kr.perfume.perfumemodule", "kr.perfume.commonmodule"})
@EntityScan("kr.perfume.commonmodule.entity.perfume")
@EnableDiscoveryClient
@EnableFeignClients
public class PerfumeModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfumeModuleApplication.class, args);
	}

}
