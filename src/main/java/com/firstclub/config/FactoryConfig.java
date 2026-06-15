package com.firstclub.config;

import com.firstclub.factory.SubscriptionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryConfig {

    @Bean
    public SubscriptionFactory subscriptionFactory() {
        return new SubscriptionFactory();
    }
}
