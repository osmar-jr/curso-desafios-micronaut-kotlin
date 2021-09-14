package br.com.zup.osmarjunior.ecommerce.request

import br.com.zup.osmarjunior.ecommerce.model.Cliente
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Introspected
data class ClienteRequest(@field:NotBlank val nome: String,
                          @field:NotBlank @field:Email val email: String) {
    fun toCliente(): Cliente {
        return Cliente(nome = nome, email = email)
    }
}
