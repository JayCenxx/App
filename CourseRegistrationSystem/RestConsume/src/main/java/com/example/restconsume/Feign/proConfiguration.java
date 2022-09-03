package com.example.restconsume.Feign;



import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration

public class proConfiguration {
    @Value("${usernames}")
    private String username;

    @Value("${passwords}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        System.out.println(username+ ""+password);
        return new BasicAuthRequestInterceptor(username, password);
    }

}
