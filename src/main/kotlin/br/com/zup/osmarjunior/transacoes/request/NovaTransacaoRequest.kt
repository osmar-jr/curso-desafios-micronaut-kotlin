package br.com.zup.osmarjunior.transacoes.request

import br.com.zup.osmarjunior.transacoes.enums.StatusDaTransacao
import br.com.zup.osmarjunior.transacoes.model.Transacao
import com.sun.istack.NotNull
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Introspected
data class NovaTransacaoRequest(
        @field:NotBlank
        val descricao: String,

        @field:NotNull
        @field:Positive
        val valor: BigDecimal,

        @field:NotNull
        @field:Enumerated(EnumType.STRING)
        val status: StatusDaTransacao,
) {

    fun toTransacao(clienteId: Long): Transacao {
        return Transacao(descricao = descricao,
                valor = valor,
                status = status,
                clienteId = clienteId)
    }
}
