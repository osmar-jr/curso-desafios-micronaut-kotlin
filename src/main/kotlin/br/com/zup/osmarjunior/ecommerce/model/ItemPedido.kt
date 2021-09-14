package br.com.zup.osmarjunior.ecommerce.model

import java.math.BigDecimal

class ItemPedido(
        val codigo: String,
        val preco: BigDecimal,
        val quantidade: Int
){
    override fun toString(): String {
        return "ItemPedido(codigo='$codigo', preco=$preco, quantidade=$quantidade)"
    }
}