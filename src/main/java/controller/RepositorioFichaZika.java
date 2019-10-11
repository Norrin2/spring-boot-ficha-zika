package controller;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import model.FichaZika;

/**
 * Repositorio para a FichaZika.
 * @version 1.0 
 * @author Rafael dos Santos
 */


public interface RepositorioFichaZika extends PagingAndSortingRepository<FichaZika, Long> {
	
	public Page<FichaZika> findByPacienteNome(String nome,Pageable pageable);

	public Page<FichaZika> findByProfissionalNome(String nomePaciente, Pageable pageable);
	
	
	/* Query nativo para a busca por resultado de exame.countQuery é necessário para a paginação */
	@Query(nativeQuery = true,value="SELECT * FROM ficha_zika where id_ficha_zika IN (SELECT t1.id_ficha_zika FROM exames t1\n" + 
			"  	 where t1.id_exame IN (SELECT t2.id_exame from resultados_exame t2\n" + 
			"    WHERE t2.descricao = ?1))\n #pageable\n",
			countQuery="SELECT count(*) FROM ficha_zika where id_ficha_zika IN (SELECT t1.id_ficha_zika FROM exames t1\n" + 
					"	where t1.id_exame IN (SELECT t2.id_exame from resultados_exame t2\n" + 
					"	WHERE t2.descricao = ?1))\n")
	public Page<FichaZika> buscaPorResultadoExame(String resultadoExame, Pageable pageable);
}