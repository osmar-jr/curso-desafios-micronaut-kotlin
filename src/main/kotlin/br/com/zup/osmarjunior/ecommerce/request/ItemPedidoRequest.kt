package br.com.zup.osmarjunior.ecommerce.request

import br.com.zup.osmarjunior.ecommerce.model.ItemPedido
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class ItemPedidoRequest(@field:NotBlank val codigo: String,
                             @field:NotNull @field:Positive val preco: BigDecimal,
                             @field:NotNull @field:Positive val quantidade: Int){

    fun toItemPedido(): ItemPedido {
        return ItemPedido(codigo = codigo, preco = preco, quantidade = quantidade)
    }

    fun getTotalItemPedido(): BigDecimal {
        return preco * quantidade.toBigDecimal()
    }
}
