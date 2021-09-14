package br.com.zup.osmarjunior.ecommerce.model

import java.math.BigDecimal

class Pedido(
        val cliente: Cliente,
        val total: BigDecimal,
        val itens: List<ItemPedido>
){
    override fun toString(): String {
        return "Pedido(cliente=$cliente, total=$total, itens=$itens)"
    }
}