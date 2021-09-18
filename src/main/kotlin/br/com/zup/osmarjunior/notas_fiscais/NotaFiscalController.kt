package br.com.zup.osmarjunior.notas_fiscais

import br.com.zup.osmarjunior.notas_fiscais.model.NotaFiscal
import br.com.zup.osmarjunior.notas_fiscais.repository.NotaFiscalRepository
import br.com.zup.osmarjunior.notas_fiscais.request.NovaNotaFiscalRequest
import br.com.zup.osmarjunior.notas_fiscais.response.NotaFiscalDetalheResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.URI
import javax.validation.Valid

@Validated
@Controller("/api/notas-fiscais")
class NotaFiscalController(val notaFiscalRepository: NotaFiscalRepository) {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @Post
    fun cadastra(@Body @Valid request: NovaNotaFiscalRequest): HttpResponse<Any>{

        val notaFiscal: NotaFiscal = request.toNotaFiscal()
        notaFiscalRepository.save(notaFiscal)

        val uriLocation: URI = UriBuilder.of("/api/notas-fiscais/{notaFiscalId}")
            .expand(mutableMapOf(Pair("notaFiscalId", notaFiscal.id)))

        val notaFiscalDetalheResponse: NotaFiscalDetalheResponse = NotaFiscalDetalheResponse(notaFiscal)
        logger.info("Nova Nota Fiscal criada: $notaFiscalDetalheResponse}")

        return HttpResponse.created(notaFiscalDetalheResponse, uriLocation)
    }

    @Get(value = "/{notaFiscalId}")
    fun listaPorNotaFiscal(@PathVariable("notaFiscalId") notaFiscalId: Long): HttpResponse<Any>{
        val optionalNotaFiscal = notaFiscalRepository.buscarPorId(notaFiscalId)

        if (optionalNotaFiscal.isEmpty) return HttpResponse.notFound("Nota Fiscal não encontrada.")

        val notaFiscal = optionalNotaFiscal.get()
        return HttpResponse.ok(NotaFiscalDetalheResponse(notaFiscal))
    }
}