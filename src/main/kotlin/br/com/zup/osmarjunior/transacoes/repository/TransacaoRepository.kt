package br.com.zup.osmarjunior.transacoes.repository

import br.com.zup.osmarjunior.transacoes.model.Transacao
import io.micronaut.data.annotation.Repository
import io.micronaut.data.model.Page
import io.micronaut.data.model.Pageable
import io.micronaut.data.repository.PageableRepository
import java.time.LocalDateTime

@Repository
interface TransacaoRepository : PageableRepository<Transacao, Long> {

    fun findByClienteIdAndCriadaEmAfterOrderByCriadaEmDesc(clienteId: Long, daysAgo: LocalDateTime, pageable: Pageable): Page<Transacao>
}