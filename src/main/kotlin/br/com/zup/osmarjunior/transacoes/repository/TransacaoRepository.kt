package br.com.zup.osmarjunior.transacoes.repository

import br.com.zup.osmarjunior.transacoes.model.Transacao
import br.com.zup.osmarjunior.transacoes.response.TransacaoDetalheResponse
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import java.time.LocalDateTime

@Repository
interface TransacaoRepository : JpaRepository<Transacao, Long> {

    fun findByClienteIdAndCriadaEmAfterOrderByCriadaEmDesc(
        clienteId: Long,
        daysAgo: LocalDateTime,
        pageable: Pageable
    ): Page<TransacaoDetalheResponse>
}