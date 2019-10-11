package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe/Entidade Profissional
 * @version 1.0 
 * @author Rafael dos Santos
 */

@Entity
@Table(name="profissionais")
public class Profissional {	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_profissional")
    @JsonProperty("idProfissional")
    private Integer id;
    
    @Column(name = "nome_profissional", length=50)    
    private String nome;
    
    @Column(name = "cns", length=15)
    private String cns;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}
    
    
}
    





  
