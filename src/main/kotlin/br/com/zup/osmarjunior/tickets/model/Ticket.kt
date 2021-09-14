package br.com.zup.osmarjunior.tickets.model

import br.com.zup.osmarjunior.tickets.model.enum.StatusTicket
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.PastOrPresent
import javax.validation.constraints.Size

@Entity
class Ticket(
        @field:NotBlank @field:Size(max = 60)
        @Column(nullable = false, length = 60)
        val titulo: String,

        @field:NotBlank @field:Size(max = 4000)
        @Column(columnDefinition = "TEXT", nullable = false, length = 4000)
        val descricao: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @field:NotNull
    @field:PastOrPresent
    @Column(nullable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now()

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    val status: StatusTicket = StatusTicket.ABERTO

    override fun toString(): String {
        return "Ticket(titulo='$titulo', descricao='$descricao', id=$id, criadoEm=$criadoEm, status=$status)"
    }
}
