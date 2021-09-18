package br.com.zup.osmarjunior.clientes

import br.com.zup.osmarjunior.clientes.request.NovoClienteRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/clientes")
class ClienteController {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @Post
    fun cadastra(@Body @Valid request: NovoClienteRequest): HttpResponse<Any>{
        logger.info("Requisição recebida com sucesso: $request")
        return HttpResponse.ok()
    }
}