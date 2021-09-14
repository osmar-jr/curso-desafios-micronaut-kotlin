package br.com.zup.osmarjunior.ecommerce.request

import br.com.zup.osmarjunior.ecommerce.model.Cliente
import br.com.zup.osmarjunior.ecommerce.model.ItemPedido
import br.com.zup.osmarjunior.ecommerce.model.Pedido
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Introspected
data class NovoPedidoRequest(@field:NotNull @field:Valid val cliente: ClienteRequest,
                             @field:NotNull @field:NotEmpty @field:Valid val pedidos: List<ItemPedidoRequest>) {

    fun toPedido(): Pedido {
        val cliente: Cliente = cliente.toCliente()
        val itemPedidos: List<ItemPedido> = pedidos.map { itemPedidoRequest -> itemPedidoRequest.toItemPedido() }
        val total: BigDecimal = getTotalPedido()
        return Pedido(cliente = cliente, total = total, itens = itemPedidos)
    }

    private fun getTotalPedido(): BigDecimal {
        val total: BigDecimal = pedidos.sumOf { itemPedidoRequest ->
            itemPedidoRequest.getTotalItemPedido()
        }
        return total
    }
}
