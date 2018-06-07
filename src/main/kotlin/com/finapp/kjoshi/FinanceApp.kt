package com.finapp.kjoshi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
open class FinanceApp
    fun main(args: Array<String>){
        println("Starting SpringBoot Application")
        SpringApplication.run(FinanceApp::class.java)
    }
