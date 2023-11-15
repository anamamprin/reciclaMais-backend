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
@Table(name = "t_bairro")
public class Bairro {
	
	@Id
	@SequenceGenerator(name="bairro",sequenceName="sq_tbl_bairro",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bairro")
    @Column(name = "cd_bairro")
    private Integer codigo;

	@Column(name = "nm_bairro", nullable = false)
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "cd_cidade")
	private Cidade cidade;
	
	@OneToMany(mappedBy = "bairro")
	private Collection<Endereco> enderecos;
	;

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

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
