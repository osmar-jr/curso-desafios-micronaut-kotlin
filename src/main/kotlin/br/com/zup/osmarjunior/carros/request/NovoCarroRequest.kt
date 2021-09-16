package br.com.zup.osmarjunior.carros.request

import br.com.zup.osmarjunior.carros.annotations.IsPlacaAutomovel
import br.com.zup.osmarjunior.carros.annotations.UniqueValue
import br.com.zup.osmarjunior.carros.model.Carro
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoCarroRequest(
        @field:NotBlank
        @field:IsPlacaAutomovel
        @field:UniqueValue(klazz = Carro::class, attribute = "placa")
        val placa: String,

        @field:NotBlank
        @field:Size(max = 60)
        val modelo: String
) {
        fun toCarro(): Carro {
                return Carro(placa = placa, modelo = modelo)
        }
}
