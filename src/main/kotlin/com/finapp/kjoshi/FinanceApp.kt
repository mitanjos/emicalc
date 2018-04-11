package com.finapp.kjoshi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class FinanceApp
    fun main(args: Array<String>){
        println("Starting SpringBoot Application")
        SpringApplication.run(FinanceApp::class.java)
    }
