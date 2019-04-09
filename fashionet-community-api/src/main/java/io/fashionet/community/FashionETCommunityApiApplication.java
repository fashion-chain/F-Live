package io.fashionet.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({
        @ComponentScan(basePackages = {
                "io.fashionet.community",
                "io.fashionet.core"
        })
})
public class FashionETCommunityApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FashionETCommunityApiApplication.class, args);
    }

}
