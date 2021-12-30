package cn.touale.cula;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Touale
 * @description NewsApplication
 * @date 2021/12/30 13:45
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("cn.touale.cula.mapper")
public class NewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewsApplication.class, args);
    }
}
