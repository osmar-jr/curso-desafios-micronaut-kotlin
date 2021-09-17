package br.com.zup.osmarjunior.notas_fiscais.repository

import br.com.zup.osmarjunior.notas_fiscais.model.NotaFiscal
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface NotaFiscalRepository : JpaRepository<NotaFiscal, Long> {

    @Query("SELECT nf FROM NotaFiscal nf INNER JOIN fetch nf.itens WHERE nf.id = :id")
    fun buscarPorId(id: Long): Optional<NotaFiscal>
}
