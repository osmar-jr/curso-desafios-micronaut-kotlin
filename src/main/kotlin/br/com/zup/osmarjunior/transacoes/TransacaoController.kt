package br.com.zup.osmarjunior.transacoes

import br.com.zup.osmarjunior.transacoes.model.Transacao
import br.com.zup.osmarjunior.transacoes.repository.TransacaoRepository
import br.com.zup.osmarjunior.transacoes.request.NovaTransacaoRequest
import br.com.zup.osmarjunior.transacoes.response.TransacaoDetalheResponse
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import java.time.LocalDateTime
import javax.validation.Valid

@Validated
@Controller("/api/clientes/{clienteId}/transacoes")
class TransacaoController(val transacaoRepository: TransacaoRepository) {

    @Post
    fun cadastra(@PathVariable("clienteId") clienteId: Long,
                 @Body @Valid request: NovaTransacaoRequest): HttpResponse<Any> {

        val transacao: Transacao = request.toTransacao(clienteId)
        transacaoRepository.save(transacao)

        val uri = UriBuilder.of("/api/clientes/{clienteId}/transacoes/{transacaoId}")
                .expand(mutableMapOf(Pair("clienteId", clienteId), Pair("transacaoId", transacao.id)))

        return HttpResponse.created(TransacaoDetalheResponse(transacao), uri)
    }

    @Get
    fun lista(
            @PathVariable("clienteId") clienteId: Long,
            pageable: Pageable = Pageable.from(0),
    ): HttpResponse<Any>{
        val daysAgo = LocalDateTime.now().minusDays(30)

        val transacoesResponsePage: Page<TransacaoDetalheResponse> = transacaoRepository
                .findByClienteIdAndCriadaEmAfterOrderByCriadaEmDesc(clienteId, daysAgo, pageable)


        return HttpResponse.ok(transacoesResponsePage)
    }
}