package cn.lhr.demo.consumerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


//@EnableCircuitBreaker

//@SpringBootApplication
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerServerApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }


    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerApplication.class, args);
    }

}
