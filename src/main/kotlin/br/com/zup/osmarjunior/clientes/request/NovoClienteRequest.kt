package br.com.zup.osmarjunior.clientes.request

import br.com.zup.osmarjunior.clientes.annotations.MaiorIdade
import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.*

@Introspected
data class NovoClienteRequest(

    @field:NotBlank
    @field:Size(max=120)
    val nome: String,

    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotNull
    @field:Past
    @field:JsonFormat(pattern = "yyyy-MM-dd")
    @field:MaiorIdade
    val dataDeNascimento: LocalDate
    // outros atributos
){
    override fun toString(): String {
        return "NovoClienteRequest(nome='$nome', email='$email', dataDeNascimento=$dataDeNascimento)"
    }
}