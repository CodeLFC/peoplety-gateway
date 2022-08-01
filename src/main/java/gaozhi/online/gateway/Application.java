package gaozhi.online.gateway;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO
 * @date 2022/5/2 12:37
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 用户服务
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackageClasses = {gaozhi.online.base.ScanClass.class, Application.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

