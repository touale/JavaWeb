package cn.touale.cula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Touale
 * @description Application
 * @date 2021/12/30 15:10
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebApplication_81 {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication_81.class, args);
    }
}
