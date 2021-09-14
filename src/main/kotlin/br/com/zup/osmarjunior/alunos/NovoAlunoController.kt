package br.com.zup.osmarjunior.alunos

import br.com.zup.osmarjunior.alunos.request.NovoAlunoRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.validation.ConstraintViolation
import javax.validation.Validator

@Controller("/api/alunos")
class NovoAlunoController {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @Inject
    lateinit var validator: Validator

    @Post
    fun cadastra(@Body request: NovoAlunoRequest): HttpResponse<Any> {
        val requestErrors: MutableSet<ConstraintViolation<NovoAlunoRequest>> = validator.validate(request)

        if (requestErrors.isNotEmpty()) return HttpResponse.badRequest(requestErrors)

        logger.info(request.toString())
        return HttpResponse.ok<Any?>().body(request)
    }
}