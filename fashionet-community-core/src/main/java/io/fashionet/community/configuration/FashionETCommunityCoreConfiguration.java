package io.fashionet.community.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.fashionet.core.base.configuration.BaseConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FashionETCommunityCoreConfiguration {

    @Bean
    public Gson applicationGson() {
        return new GsonBuilder()
                .create();
    }

    public static Gson getApplicationGson() {
        return (Gson) BaseConfiguration.getContext().getBean("applicationGson");
    }
}
