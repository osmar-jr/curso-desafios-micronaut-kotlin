package br.com.zup.osmarjunior.clientes.validators

import br.com.zup.osmarjunior.clientes.annotations.MaiorIdade
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import jakarta.inject.Singleton
import java.time.LocalDate
import java.time.Period

@Singleton
class MaiorIdadeValidator : ConstraintValidator<MaiorIdade, LocalDate?> {
    override fun isValid(
        value: LocalDate?,
        annotationMetadata: AnnotationValue<MaiorIdade>,
        context: ConstraintValidatorContext
    ): Boolean {
        if (value == null) {
            return true
        }

        val period: Period = Period.between(value, LocalDate.now())

        return period.years >= 18
    }

}
