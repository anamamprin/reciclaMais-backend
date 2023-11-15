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
@Table(name = "t_usuario")
public class Usuario {
	
	@Id
	@SequenceGenerator(name="usuario",sequenceName="sq_tbl_usuario",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario")
    @Column(name = "cd_usuario")
    private Integer codigo;
	
	@Column(name = "tp_usuario", nullable = false)
    private String tipo;
	
	@Column(name = "nm_usuario", nullable = false)
    private String nome;
	
	@Column(name = "tp_documento", nullable = false)
    private String tipoDocumento;
	
	@Column(name = "ds_documento", nullable = false)
    private String documento;
	
	@Column(name = "ds_email", nullable = false)
    private String email;
	
	@Column(name = "ds_senha", nullable = false)
    private String senha;
	
	@Column(name = "nr_telefone", nullable = false)
    private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "ds_cep")
	private Endereco endereco;
	
	@Column(name = "nr_endereço", nullable = false)
    private int numeroEndereco;
	
	@OneToMany(mappedBy = "usuario")
	private Collection<UsuarioReciclavel> reciclaveis;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public Collection<UsuarioReciclavel> getReciclaveis() {
		return reciclaveis;
	}

	public void setReciclaveis(Collection<UsuarioReciclavel> reciclaveis) {
		this.reciclaveis = reciclaveis;
	}
	
}
