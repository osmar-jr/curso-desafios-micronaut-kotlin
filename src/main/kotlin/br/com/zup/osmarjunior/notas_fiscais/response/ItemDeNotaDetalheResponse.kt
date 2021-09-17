package br.com.zup.osmarjunior.notas_fiscais.response

import br.com.zup.osmarjunior.notas_fiscais.model.ItemDeNotaFiscal
import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Introspected
data class ItemDeNotaDetalheResponse(
    @field:NotNull @field:Positive val valor: BigDecimal,
    @field:NotNull @field:Positive val quantidade: Int
) {

    constructor(@NotNull @Valid itemDeNotaFiscal: ItemDeNotaFiscal) : this(
        valor = itemDeNotaFiscal.valor,
        quantidade = itemDeNotaFiscal.quantidade
    )
}
