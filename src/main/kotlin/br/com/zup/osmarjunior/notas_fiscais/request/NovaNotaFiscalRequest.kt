package br.com.zup.osmarjunior.notas_fiscais.request

import br.com.zup.osmarjunior.notas_fiscais.model.NotaFiscal
import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Introspected
data class NovaNotaFiscalRequest(
    @field:NotBlank
    val numero: String,

    @field:NotBlank
    val serie: String,

    @field:NotNull
    @field:JsonFormat(pattern = "yyyy-MM-dd")
    val data: LocalDate,

    @field:NotNull
    @field:NotEmpty
    @field:Valid
    val itens: Set<ItemDeNotaRequest>,
) {
    fun toNotaFiscal(): NotaFiscal {
        return NotaFiscal(numero = numero, serie = serie, data = data, itensDeNotaFiscalRequest = itens)
    }
}