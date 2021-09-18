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
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import javax.validation.Valid

@Validated
@Controller("/api/clientes/{clienteId}/transacoes")
class TransacaoController(val transacaoRepository: TransacaoRepository) {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass.name)

    @Post
    fun cadastra(@PathVariable("clienteId") clienteId: Long,
                 @Body @Valid request: NovaTransacaoRequest): HttpResponse<Any> {

        val transacao: Transacao = request.toTransacao(clienteId)
        transacaoRepository.save(transacao)

        val uri = UriBuilder.of("/api/clientes/{clienteId}/transacoes/{transacaoId}")
                .expand(mutableMapOf(Pair("clienteId", clienteId), Pair("transacaoId", transacao.id)))

        val transacaoDetalheResponse = TransacaoDetalheResponse(transacao)
        logger.info("Nova Transação criada: $transacaoDetalheResponse")

        return HttpResponse.created(transacaoDetalheResponse, uri)
    }

    @Get
    fun lista(
            @PathVariable("clienteId") clienteId: Long,
            pageable: Pageable = Pageable.from(0),
    ): HttpResponse<Any>{
        val daysAgo = LocalDateTime.now().minusDays(30)

        val transacoesResponsePage: Page<TransacaoDetalheResponse> = transacaoRepository
                .findByClienteIdAndCriadaEmAfterOrderByCriadaEmDesc(clienteId, daysAgo, pageable)

        logger.info("Novo relatório emitido para a transações emitido.")
        return HttpResponse.ok(transacoesResponsePage)
    }
}