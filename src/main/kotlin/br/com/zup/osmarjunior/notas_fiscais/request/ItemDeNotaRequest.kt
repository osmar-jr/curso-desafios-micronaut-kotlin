package br.com.zup.osmarjunior.notas_fiscais.request

import br.com.zup.osmarjunior.notas_fiscais.model.ItemDeNotaFiscal
import br.com.zup.osmarjunior.notas_fiscais.model.NotaFiscal
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class ItemDeNotaRequest(
    @field:NotNull
    @field:Positive
    val valor: BigDecimal,

    @field:NotNull
    @field:Positive
    val quantidade: Int,
) {
    fun toItemDeNotaFiscal(@NotNull @Valid notaFiscal: NotaFiscal) : ItemDeNotaFiscal{
        return ItemDeNotaFiscal(
            valor = valor,
            quantidade = quantidade,
            notaFiscal = notaFiscal
        )
    }
}