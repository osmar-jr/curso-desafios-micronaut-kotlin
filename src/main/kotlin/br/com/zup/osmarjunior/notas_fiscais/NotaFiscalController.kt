package br.com.zup.osmarjunior.notas_fiscais

import br.com.zup.osmarjunior.notas_fiscais.model.NotaFiscal
import br.com.zup.osmarjunior.notas_fiscais.repository.NotaFiscalRepository
import br.com.zup.osmarjunior.notas_fiscais.request.NovaNotaFiscalRequest
import br.com.zup.osmarjunior.notas_fiscais.response.NotaFiscalDetalheResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import java.net.URI
import javax.validation.Valid

@Validated
@Controller("/api/notas-fiscais")
class NotaFiscalController(val notaFiscalRepository: NotaFiscalRepository) {

    @Post
    fun cadastra(@Body @Valid request: NovaNotaFiscalRequest): HttpResponse<Any>{

        val notaFiscal: NotaFiscal = request.toNotaFiscal()
        notaFiscalRepository.save(notaFiscal)

        val uriLocation: URI = UriBuilder.of("/api/notas-fiscais/{notaFiscalId}")
            .expand(mutableMapOf(Pair("notaFiscalId", notaFiscal.id)))

        val notaFiscalDetalheResponse: NotaFiscalDetalheResponse = NotaFiscalDetalheResponse(notaFiscal)

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