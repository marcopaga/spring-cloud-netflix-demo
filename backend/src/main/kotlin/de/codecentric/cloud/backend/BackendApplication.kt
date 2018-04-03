package de.codecentric.cloud.backend

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class BackendApplication {

}

fun main(args: Array<String>){
    SpringApplication.run(BackendApplication::class.java, *args)
}