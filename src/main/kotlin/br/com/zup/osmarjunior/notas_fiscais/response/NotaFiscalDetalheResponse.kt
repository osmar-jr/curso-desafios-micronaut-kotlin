package br.com.zup.osmarjunior.notas_fiscais.response

import br.com.zup.osmarjunior.notas_fiscais.model.NotaFiscal
import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Introspected
data class NotaFiscalDetalheResponse(
    @field:NotBlank val numero: String,
    @field:NotBlank val serie: String,
    @field:NotNull @field:JsonFormat(pattern = "yyyy-MM-dd") val data: LocalDate,
    @field:NotNull @field:NotEmpty @field:Valid val itens: List<ItemDeNotaDetalheResponse>
) {

    constructor(@NotNull @Valid notaFiscal: NotaFiscal) : this(
        numero = notaFiscal.numero,
        serie = notaFiscal.serie,
        data = notaFiscal.data,
        itens = notaFiscal.itens.map { itemDeNotaFiscal -> ItemDeNotaDetalheResponse(itemDeNotaFiscal) }
    )

}
