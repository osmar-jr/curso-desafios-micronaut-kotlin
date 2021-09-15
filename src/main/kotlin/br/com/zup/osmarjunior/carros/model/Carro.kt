package br.com.zup.osmarjunior.carros.model

import br.com.zup.osmarjunior.carros.annotations.IsPlacaAutomovel
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Carro(
        @field:NotBlank
        @field:IsPlacaAutomovel
        @Column(nullable = false, unique = true)
        val placa: String,

        @field:NotBlank
        @field:Size(max = 60)
        @Column(nullable = false, length = 60)
        val modelo: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    override fun toString(): String {
        return "Carro(placa='$placa', modelo='$modelo', id=$id)"
    }
}