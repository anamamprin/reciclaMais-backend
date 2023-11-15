package br.com.fiap.reciclamais.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_estado")
public class Estado {
	
	@Id
    @Column(name = "cd_estado")
    private String uf;

	@Column(name = "nm_estado")
    private String nome;
	
	@OneToMany(mappedBy = "estado")
	private Collection<Cidade> cidades;

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}

	
}
