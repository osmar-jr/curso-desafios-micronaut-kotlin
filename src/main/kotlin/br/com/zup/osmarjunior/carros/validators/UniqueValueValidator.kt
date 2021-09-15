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
class UniqueValueValidator(constraintAnnotation: UniqueValue): ConstraintValidator<UniqueValue, Any> {

    private var klazz: KClass<*> = constraintAnnotation.klazz
    private var attribute: String = constraintAnnotation.attribute

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun isValid(value: Any?,
                         annotationMetadata: AnnotationValue<UniqueValue>,
                         context: ConstraintValidatorContext): Boolean {
        if (value == null) return true
        val query: Query = entityManager.createQuery("select 1 from $klazz where $attribute =: $value")
        val resultList: MutableList<Any?> = query.resultList

        return resultList.isEmpty()
    }

}
