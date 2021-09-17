package br.com.zup.osmarjunior.notas_fiscais.model

import br.com.zup.osmarjunior.notas_fiscais.request.ItemDeNotaRequest
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
class NotaFiscal(
    @field:NotBlank
    @Column(unique = true)
    val numero: String,

    @field:NotBlank
    @Column(unique = true)
    val serie: String,

    @field:NotNull
    @Column(unique = false)
    val data: LocalDate
) {

    @JsonManagedReference
    @JoinColumn(name = "NOTA_FISCAL_ID")
    @OneToMany(
        targetEntity = ItemDeNotaFiscal::class,
        fetch = FetchType.LAZY,
        cascade = arrayOf(CascadeType.PERSIST)
    )
    lateinit var itens: Set<ItemDeNotaFiscal>

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    constructor(
        numero: String,
        serie: String,
        data: LocalDate,
        itensDeNotaFiscalRequest: Set<ItemDeNotaRequest>
    ): this(numero = numero, serie = serie, data = data) {
        this.itens = itensDeNotaFiscalRequest
            .map { itemDeNotaRequest -> itemDeNotaRequest.toItemDeNotaFiscal(this) }
            .toSet()
    }
}
