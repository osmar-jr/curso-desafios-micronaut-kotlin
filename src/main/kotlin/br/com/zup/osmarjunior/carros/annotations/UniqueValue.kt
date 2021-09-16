package br.com.zup.osmarjunior.carros.annotations

import br.com.zup.osmarjunior.carros.validators.UniqueValueValidator
import jakarta.inject.Singleton
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Singleton
@MustBeDocumented
@Target(AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UniqueValueValidator::class])
annotation class UniqueValue(val klazz: KClass<out Any>,
                             val attribute: String,
                             val message: String = "Value already exists.",
                             val groups: Array<KClass<Any>> = [],
                             val payload: Array<KClass<Payload>> = [])
