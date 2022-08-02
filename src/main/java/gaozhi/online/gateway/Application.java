package gaozhi.online.gateway;

/**
 * @author LiFucheng
 * @version 1.0
 * @description: TODO
 * @date 2022/5/2 12:37
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

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

    /**
     * @description: 限流策略  获取访问者的ip地址, 通过访问者ip地址进行限流, 限流使用的是Redis中的令牌桶算法
     * @param:
     * @return: org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
     * @author LiFucheng
     * @date: 2022/8/2 13:37
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //获取访问者的ip地址, 通过访问者ip地址进行限流, 限流使用的是Redis中的令牌桶算法
                String hostString = exchange.getRequest().getRemoteAddress().getHostString();
                return Mono.just(hostString);
            }
        };
    }

}

