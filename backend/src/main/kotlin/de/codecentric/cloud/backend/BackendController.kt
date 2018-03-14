package de.codecentric.cloud.backend

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RequestMapping
@RestController
class BackendController{

    @Bean
    fun routerFunction(handler: BackendHandler) : RouterFunction<ServerResponse> = router {
        GET("/"){
            ServerResponse.ok().body(handler.indexPage())
        }
        GET("/add/{first}/{second}"){ request ->
            val first : Int= request.pathVariable("first").toInt()
            val second : Int = request.pathVariable("second").toInt()
            ServerResponse.ok().body(handler.add(Flux.just(first, second)))
        }
    }
}

@Component
class BackendHandler {

    fun indexPage(): Mono<String> {
        val hostname = System.getenv("HOSTNAME")
        return Mono.just("Backend Application on $hostname")
    }

    fun add(values: Flux<Int>): Mono<Int>{
        return values.reduce(Int::plus)
    }
}