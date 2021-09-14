package br.com.zup.osmarjunior.ecommerce

import br.com.zup.osmarjunior.ecommerce.model.Pedido
import br.com.zup.osmarjunior.ecommerce.request.NovoPedidoRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/pedidos")
class NovoPedidoController {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @Post
    fun cadastra(@Body @Valid request: NovoPedidoRequest): HttpResponse<Any> {
        val pedido: Pedido = request.toPedido()
        logger.info(pedido.toString())
        return HttpResponse.ok(request)
    }
}