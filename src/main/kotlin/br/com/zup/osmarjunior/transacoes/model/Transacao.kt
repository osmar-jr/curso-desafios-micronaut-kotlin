package br.com.zup.osmarjunior.transacoes.model

import br.com.zup.osmarjunior.transacoes.enums.StatusDaTransacao
import com.sun.istack.NotNull
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Positive

@Entity
class Transacao(
        @field:NotBlank
        @Column(nullable = false)
        val descricao: String,

        @field:NotNull
        @field:Positive
        @Column(nullable = false)
        val valor: BigDecimal,

        @field:NotNull
        @field:Enumerated(EnumType.STRING)
        @Column(nullable = false)
        val status: StatusDaTransacao = StatusDaTransacao.INICIADA,

        @field:NotNull
        @field:Positive
        @Column(nullable = false)
        val clienteId: Long,

        @field:NotNull
        @Column(nullable = false, updatable = false)
        val criadaEm: LocalDateTime = LocalDateTime.now(),
) {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        var id: Long? = null
}
