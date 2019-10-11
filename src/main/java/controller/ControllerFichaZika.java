package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.FichaZika;

/**
 * Controllador da FichaZika.
 * Contem os metodos de GET, POST e DELETE
 * @version 1.0 
 * @author Rafael dos Santos
 */

@Controller
@CrossOrigin
@RequestMapping(path="/")
public class ControllerFichaZika {

	@Autowired /* recupera o bean criado pelo Spring */
	private RepositorioFichaZika repositorio;

	
	
	@GetMapping(path="/zika")
	public @ResponseBody ResponseEntity<Object> getFichas(
		@RequestParam(defaultValue="1") Integer numeroDaPagina,
		@RequestParam(defaultValue="10") Integer tamanhoDaPagina,
		@RequestParam(required=false) String nomePaciente,
		@RequestParam(required=false) String nomeProfissional,
		@RequestParam(required=false) String resultadoExame){
		try {
			Pageable pageable = new PageRequest((numeroDaPagina -1),tamanhoDaPagina); // Subtrai 1 pois o spring começa na página 0, o que não é muito inutivo
			if (nomePaciente != null) {
				return new ResponseEntity<Object>(repositorio.findByPacienteNome(nomePaciente,pageable),HttpStatus.OK);
			}
			
			if (nomeProfissional != null) {
				return new ResponseEntity<Object>(repositorio.findByProfissionalNome(nomePaciente,pageable),HttpStatus.OK);
			}
			
			if (resultadoExame != null) {
				return new ResponseEntity<Object>(repositorio.buscaPorResultadoExame(resultadoExame, pageable),HttpStatus.OK);
			}
			/* Retorna tudo caso não haja parametros de pesquisa */
			return new ResponseEntity<Object>(repositorio.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Algo de Errado Aconteceu!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path="/zika")
	public @ResponseBody ResponseEntity<Object> adicionaFicha (@RequestBody Iterable<FichaZika> conteudo) {
		try {
			repositorio.save(conteudo);
			return new ResponseEntity<Object>("Sucesso!",HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Algo de Errado Aconteceu!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path="/zika") public @ResponseBody ResponseEntity<Object> excluiFicha (@RequestBody FichaZika conteudo) {
		try {
			repositorio.delete(conteudo);
			return new ResponseEntity<Object>("Sucesso!",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Algo de Errado Aconteceu!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
