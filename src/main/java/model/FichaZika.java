package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Classe/Entidade FichaZika
 * @version 1.0 
 * @author Rafael dos Santos
 */

@Entity
@Table(name="ficha_zika")
@JsonPropertyOrder({ "dataAtendimento", "exames" , "idZika", "paciente", "profissional", "turno" })
public class FichaZika {	

    @JsonProperty("dataAtendimento") /* Nome do campo no JSON */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone="GMT+3") /* Converte o timestamp no formato específicado */
    @Temporal(TemporalType.TIMESTAMP) /* Assegura que o campo criado no BD é timestamp conforme especificado */
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date data_atendimento;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_ficha_zika") /* especifica a chave estrangeira para evitar que o JPA crie tabelas auxiliares desnecessárias no BD */
    private List<Exame> exames;
       
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_ficha_zika")
    @JsonProperty("idZika")
    private Integer id;
  
    @ManyToOne(cascade = CascadeType.ALL)
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.ALL)
    private Profissional profissional;

    
    @Column(length = 1)
    @JsonSerialize(using = SerializadorTurno.class)
    private String turno;
    
    
	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getData_atendimento() {
		return data_atendimento;
	}

	public void setData_atendimento(Date data_atendimento) {
		this.data_atendimento = data_atendimento;
	}

    
    
}
    





  
