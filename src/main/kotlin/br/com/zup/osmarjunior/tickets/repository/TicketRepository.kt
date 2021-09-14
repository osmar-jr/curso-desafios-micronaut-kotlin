package br.com.zup.osmarjunior.tickets.repository

import br.com.zup.osmarjunior.tickets.model.Ticket
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface TicketRepository: JpaRepository<Ticket, Long> {

}
