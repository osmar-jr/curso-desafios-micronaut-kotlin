package br.com.zup.osmarjunior.carros.validators

import br.com.zup.osmarjunior.carros.annotations.IsPlacaAutomovel
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import jakarta.inject.Singleton

@Singleton
class PlacaValidator: ConstraintValidator<IsPlacaAutomovel, String>{
    override fun isValid(value: String?,
                         annotationMetadata: AnnotationValue<IsPlacaAutomovel>,
                         context: ConstraintValidatorContext): Boolean {
        if (value.isNullOrBlank()) return false

        return value.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}".toRegex())
    }
}
