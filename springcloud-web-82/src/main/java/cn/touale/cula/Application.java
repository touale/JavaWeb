package cn.touale.cula;

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
@EnableFeignClients//弃用Feign客户端
public class Application {
    public static void main(String[] args) {


    }
}
