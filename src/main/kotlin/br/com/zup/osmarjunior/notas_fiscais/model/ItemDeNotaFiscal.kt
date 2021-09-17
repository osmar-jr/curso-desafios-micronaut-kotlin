package br.com.zup.osmarjunior.notas_fiscais.model

import com.fasterxml.jackson.annotation.JsonBackReference
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class ItemDeNotaFiscal(
    @field:NotNull
    @field:Positive
    @Column(nullable = false)
    val valor: BigDecimal,

    @field:NotNull
    @field:Positive
    @Column(nullable = false)
    val quantidade: Int,

    @field:NotNull
    @field:Valid
    @JsonBackReference
    @ManyToOne
    val notaFiscal: NotaFiscal
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
