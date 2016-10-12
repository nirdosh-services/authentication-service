package com.nirdosh.application;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;

@EnableMongoHttpSession
public class SessionConfig {

    @Bean
    JdkMongoSessionConverter jdkMongoSessionConverter(){
        return new JdkMongoSessionConverter();
    }
}
