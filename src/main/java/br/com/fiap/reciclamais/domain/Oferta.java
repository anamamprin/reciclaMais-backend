package br.com.fiap.reciclamais.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_oferta")
public class Oferta {
	
	@Id
	@SequenceGenerator(name="oferta",sequenceName="sq_tbl_oferta",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="oferta")
    @Column(name = "cd_oferta")
    private Integer codigo;
	
	@Column(name= "dt_oferta", nullable = false)
	private LocalDateTime dataOferta;
	
	@Column(name = "tp_oferta", nullable = false)
	private String tipoOferta;
	
	@ManyToOne
	@JoinColumn(name= "cd_usuario_reciclavel")
	private UsuarioReciclavel usuarioReciclavel;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(LocalDateTime dataOferta) {
		this.dataOferta = dataOferta;
	}

	public String getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(String tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public UsuarioReciclavel getUsuarioReciclavel() {
		return usuarioReciclavel;
	}

	public void setUsuarioReciclavel(UsuarioReciclavel usuarioReciclavel) {
		this.usuarioReciclavel = usuarioReciclavel;
	}
	
	

}
