package br.com.fiap.reciclamais.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_endereco")
public class Endereco {
	
	@Id
    @Column(name = "ds_cep")
    private String cep;

	@Column(name = "ds_lograduro", nullable = false)
    private String logradouro;
	
	@ManyToOne
	@JoinColumn(name = "cd_bairro")
	private Bairro bairro;
	
	@OneToMany(mappedBy = "endereco")
	private Collection<Usuario> usuarios;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	


}
