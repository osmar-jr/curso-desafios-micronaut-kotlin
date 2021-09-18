package br.com.zup.osmarjunior.clientes.annotations

import br.com.zup.osmarjunior.clientes.validators.MaiorIdadeValidator
import jakarta.inject.Singleton
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

@Singleton
@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)
@Retention(RUNTIME)
@Constraint(validatedBy = [MaiorIdadeValidator::class])
annotation class MaiorIdade(
    val message: String = "Idade dever ser maior ou igual a 18 anos.",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)
