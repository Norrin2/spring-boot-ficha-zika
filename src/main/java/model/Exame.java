package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe/Entidade Exame
 * @version 1.0 
 * @author Rafael dos Santos
 */

@Entity
@Table(name="exames")
public class Exame {	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_exame")
    private Integer id;
    
    @Column(name = "descricao", length=30)    
    private String descricao;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_exame") /* especifica a chave estrangeira para evitar que o JPA crie tabelas auxiliares desnecessárias no BD */
    private List<ResultadoExame> resultados;
    
	public List<ResultadoExame> getResultados() {
		return resultados;
	}

	public void setResultados(List<ResultadoExame> resultados) {
		this.resultados = resultados;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    
    
}
    





  
