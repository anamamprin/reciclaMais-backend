package br.com.fiap.reciclamais.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_cidade")
public class Cidade {
	
	@Id
	@SequenceGenerator(name="cidade",sequenceName="sq_tbl_cidade",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cidade")
    @Column(name = "cd_cidade")
    private Integer codigo;

	@Column(name = "nm_cidade", nullable = false)
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "cd_estado")
	private Estado estado;
	
	@OneToMany(mappedBy = "cidade")
	private Collection<Bairro> bairros;

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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Collection<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(Collection<Bairro> bairros) {
		this.bairros = bairros;
	}

	
}
