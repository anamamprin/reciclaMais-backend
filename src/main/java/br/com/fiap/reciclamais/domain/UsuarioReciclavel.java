package br.com.fiap.reciclamais.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_usuario_reciclavel")
public class UsuarioReciclavel {
	
	@Id
	@SequenceGenerator(name="usuario_reciclavel",sequenceName="sq_tbl_usuario_reciclavel",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="usuario_reciclavel")
    @Column(name = "cd_usuario_reciclavel")
    private Integer codigo;
	
	@OneToOne
	@JoinColumn(name = "cd_usuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "cd_reciclavel")
	private Reciclavel reciclavel;
	
	@Column(name = "ativo")
	private boolean ativo;
	
	@OneToMany(mappedBy= "usuarioReciclavel")
	Collection<Oferta> ofertas;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reciclavel getReciclavel() {
		return reciclavel;
	}

	public void setReciclavel(Reciclavel reciclavel) {
		this.reciclavel = reciclavel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Collection<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(Collection<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	

}
