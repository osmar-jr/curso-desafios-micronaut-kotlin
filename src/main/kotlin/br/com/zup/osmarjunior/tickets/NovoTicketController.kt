package br.com.zup.osmarjunior.tickets

import br.com.zup.osmarjunior.tickets.model.Ticket
import br.com.zup.osmarjunior.tickets.repository.TicketRepository
import br.com.zup.osmarjunior.tickets.request.NovoTicketRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Validated
@Controller("/api/tickets")
class NovoTicketController(val ticketRepository: TicketRepository) {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @Post
    fun cadastra(@Body @Valid request: NovoTicketRequest): HttpResponse<Any>{
        val ticket: Ticket = request.toTicket()

        ticketRepository.save(ticket)
        logger.info("Novo Ticket gerado: $ticket")

        return HttpResponse.created(request)
    }
}