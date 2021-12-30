package cn.touale.cula;

/**
 * @author Touale
 * @description EurekaApplication
 * @date 2021/12/30 12:44
 */
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_7001.class,args);
    }


}
