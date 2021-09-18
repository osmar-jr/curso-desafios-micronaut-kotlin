package br.com.zup.osmarjunior.transacoes.response

import br.com.zup.osmarjunior.transacoes.model.Transacao
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime

@Introspected
data class TransacaoDetalheResponse(
    val descricao: String,
    val valor: BigDecimal,
    val criadaEm: LocalDateTime
){
    constructor(transacao: Transacao) : this(transacao.descricao,
        transacao.valor,
        transacao.criadaEm)

    override fun toString(): String {
        return "TransacaoDetalheResponse(descricao='$descricao', valor=$valor, criadaEm=$criadaEm)"
    }

}