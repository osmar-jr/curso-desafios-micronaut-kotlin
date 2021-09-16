package br.com.zup.osmarjunior.carros.validators

import br.com.zup.osmarjunior.carros.annotations.UniqueValue
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.transaction.annotation.TransactionalAdvice
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import jakarta.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query
import kotlin.reflect.KClass

@TransactionalAdvice
@Singleton
class UniqueValueValidator: ConstraintValidator<UniqueValue, Any> {

    private lateinit var klazz: KClass<out Any>
    private lateinit var attribute: String

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun initialize(constraintAnnotation: UniqueValue) {
        this.klazz = constraintAnnotation.klazz
        this.attribute = constraintAnnotation.attribute
    }

    override fun isValid(value: Any,
                         annotationMetadata: AnnotationValue<UniqueValue>,
                         context: ConstraintValidatorContext): Boolean {

        val query: Query = entityManager
                .createQuery("select 1 from ${klazz.simpleName} where $attribute = :value")
                .setParameter("value", value)
        val resultList = query.resultList

        return resultList.isEmpty()
    }

}
