package com.example.demo

import feign.Logger
import org.springframework.context.annotation.Bean

class GoogleClientConfiguration {

    @Bean
    fun feignLoggerLevel(): Logger.Level {
        return Logger.Level.BASIC
    }
}
