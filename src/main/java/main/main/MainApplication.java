package main.main;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author n.zhuchkevich
 * @since 09/21/2020
 */
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = {"model.entity"})
public class MainApplication {

    public static void main(String[] args) {
        run(MainApplication.class, args);
    }

}
