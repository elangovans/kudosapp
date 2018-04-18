package com.intuit.slackapps.kudos

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KudosApplication

fun main(args: Array<String>) {
    SpringApplication.run(KudosApplication::class.java, *args)
}

