package com.finapp.kjoshi.config

import org.slf4j.LoggerFactory
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class RestClientConfig{

    private val logger = LoggerFactory.getLogger(RestClientConfig::class.java)

    @Bean("restTemplate1")
    open fun createRestTecmplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate? {
        logger.info("Building RestTemplate")
        return restTemplateBuilder.build()
    }

    @Bean("restTemplate2")
    open fun createAnotherRestTecmplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate? {
        logger.info("Building RestTemplate")
        return restTemplateBuilder.build()
    }
}