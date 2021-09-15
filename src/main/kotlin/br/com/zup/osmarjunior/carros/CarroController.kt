package br.com.zup.osmarjunior.carros

import br.com.zup.osmarjunior.carros.model.Carro
import br.com.zup.osmarjunior.carros.repository.CarroRepository
import br.com.zup.osmarjunior.carros.request.NovoCarroRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.validation.Valid

@Validated
@Controller("/api/carros")
class CarroController(val carroRepository: CarroRepository) {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @Post
    fun cadastra(@Body @Valid request: NovoCarroRequest): HttpResponse<Any>{
        val optional: Optional<Carro> = carroRepository.findByPlaca(request.placa)

        if (optional.isPresent) return HttpResponse.badRequest("Carro já existe.")

        val carro: Carro = request.toCarro()
        carroRepository.save(carro)
        logger.info("Novo Carro Criado: ${carro.toString()}")

        return HttpResponse.created(request)
    }
}