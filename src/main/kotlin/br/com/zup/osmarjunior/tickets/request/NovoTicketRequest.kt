package br.com.zup.osmarjunior.tickets.request

import br.com.zup.osmarjunior.tickets.model.Ticket
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoTicketRequest(
        @field:NotBlank @field:Size(max = 60)
        val titulo: String,

        @field:NotBlank @field:Size(max = 4000)
        val descricao: String

) {

    fun toTicket(): Ticket {
        return Ticket(titulo = titulo, descricao = descricao)
    }
}
