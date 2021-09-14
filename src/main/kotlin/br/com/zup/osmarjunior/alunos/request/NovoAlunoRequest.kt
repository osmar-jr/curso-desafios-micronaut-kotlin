package br.com.zup.osmarjunior.alunos.request

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class NovoAlunoRequest(@field:NotBlank @field:Size(max = 60) val nome: String,
                            @field:NotBlank @field:Email @field:Size(max = 42) val email: String,
                            @field:Min(18) val idade: Int)

