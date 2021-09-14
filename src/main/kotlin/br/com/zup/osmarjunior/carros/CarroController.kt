package br.com.zup.osmarjunior.carros

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Validated
@Controller("/api/carros")
class CarroController {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @Post
    fun cadastra(): HttpResponse<Any>{
        return HttpResponse.ok()
    }
}