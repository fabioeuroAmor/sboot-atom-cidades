package br.com.elo.repository;

import br.com.elo.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    /* Query JPQL */
    @Query("FROM Cidade c WHERE UPPER(c.dcNome) LIKE UPPER(CONCAT('%', :searchTerm, '%'))")
    Cidade search(@Param("searchTerm") String searchTerm);

    /* Query JPQL */
    @Query("SELECT c FROM Cidade c WHERE UPPER(c.dcNome) = UPPER(:dcNome)")
    Cidade buscarPorNome(@Param("dcNome") String dcNome);

    /* Query NATIVA */
    @Query(value = "SELECT * FROM TBL_CIDADE c WHERE UPPER(c.dc_nome) = UPPER(:dcNome)", nativeQuery = true)
    Cidade buscarPorNomeQueryNativa(@Param("dcNome") String dcNome);



}
