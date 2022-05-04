package poc.com.quintoandar.guarantee.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "poc.com.quintoandar.guarantee")
@EnableJpaRepositories(basePackages = { "poc.com.quintoandar.guarantee.infrastructure" })
@EntityScan(basePackages = { "poc.com.quintoandar.guarantee.infrastructure" })
@EnableCaching
public class PresentationApplication {
    public static void main(String[] args) {
        SpringApplication.run(PresentationApplication.class, args);
    }
}
