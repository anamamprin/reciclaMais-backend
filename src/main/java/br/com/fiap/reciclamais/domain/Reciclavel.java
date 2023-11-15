package br.com.fiap.reciclamais.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_reciclavel")
public class Reciclavel {
	
	@Id
	@SequenceGenerator(name="reciclavel",sequenceName="sq_tbl_reciclavel",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reciclavel")
    @Column(name = "cd_reciclavel")
    private Integer codigo;
	
	@Column(name = "nm_reciclavel", nullable = false)
	private String nome;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
