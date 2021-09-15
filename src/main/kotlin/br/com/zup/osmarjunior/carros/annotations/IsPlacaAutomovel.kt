package br.com.zup.osmarjunior.carros.annotations

import br.com.zup.osmarjunior.carros.validators.PlacaValidator
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PlacaValidator::class])
annotation class IsPlacaAutomovel(
        val message: String = "Valor deve ser uma placa de automóvel.",
        val groups: Array<KClass<Any>> = [],
        val payload: Array<KClass<Payload>> = []
)
