package com.estsoft.pilot.global.config;

import com.estsoft.pilot.global.error.FeignClientExceptionErrorDecoder;
import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "com.estsoft.pilot")
@Import(FeignClientsConfiguration.class)
public class FeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    @ConditionalOnMissingBean(value = ErrorDecoder.class)
    public FeignClientExceptionErrorDecoder commonFeignErrorDecoder() {
        return new FeignClientExceptionErrorDecoder();
    }

}