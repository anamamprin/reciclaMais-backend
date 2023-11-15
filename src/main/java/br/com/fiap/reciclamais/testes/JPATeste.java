package br.com.fiap.reciclamais.testes;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.reciclamais.dao.BairroDAO;
import br.com.fiap.reciclamais.domain.Bairro;
import br.com.fiap.reciclamais.domain.Cidade;
import br.com.fiap.reciclamais.domain.Endereco;
import br.com.fiap.reciclamais.domain.Estado;
import br.com.fiap.reciclamais.domain.Oferta;
import br.com.fiap.reciclamais.domain.Reciclavel;
import br.com.fiap.reciclamais.domain.TipoDocumento;
import br.com.fiap.reciclamais.domain.TipoOferta;
import br.com.fiap.reciclamais.domain.TipoUsuario;
import br.com.fiap.reciclamais.domain.Usuario;
import br.com.fiap.reciclamais.domain.UsuarioReciclavel;

public class JPATeste {public static void main(String[] args) {
	EntityManager em = null;
	try {
		em = Persistence.createEntityManagerFactory("jpahibernate").createEntityManager();
		
		/* Criando o estado */
		em.getTransaction().begin();
		Estado saoPaulo = new Estado();
		saoPaulo.setNome("São Paulo");
		saoPaulo.setUf("SP");
		saoPaulo = em.merge(saoPaulo);
		em.getTransaction().commit();
		
		/* Criando a cidade */
		em.getTransaction().begin();
		Cidade santoAndre = new Cidade();
		santoAndre.setEstado(saoPaulo);
		santoAndre.setNome("Santo André");
		santoAndre = em.merge(santoAndre);
		em.getTransaction().commit();
		
		/* Criando o bairro */
		Bairro utinga = new Bairro();
		utinga.setNome("Utinga");
		utinga.setCidade(santoAndre);
		new BairroDAO(em).cadastrar(utinga);
	
		/*Criando Endereço*/
		em.getTransaction().begin();
		Endereco end = new Endereco();
		end.setBairro(utinga);
		end.setCep("03232000");
		end.setLogradouro("Rua do teste");
		end = em.merge(end);
		em.getTransaction().commit();
		
		/*Criando Usuário */
		em.getTransaction().begin();
		Usuario user = new Usuario();
		user.setDocumento("22222222222000122");
		user.setTipoDocumento(TipoDocumento.CNPJ.name());
		user.setEmail("condominioX@gmail.com");
		user.setSenha("12345");
		user.setNome("Condominio X");
		user.setEndereco(end);
		user.setTelefone("44444444");
		user.setTipo(TipoUsuario.CONDOMINIO.name());
		user = em.merge(user);
		em.getTransaction().commit();
		
		/*Criando  Reciclavel */
		em.getTransaction().begin();
		Reciclavel oleo = new Reciclavel();
		oleo.setNome("Oleo");
		oleo = em.merge(oleo);
		em.getTransaction().commit();
		
		/*Criando Usuário Reciclavel */
		em.getTransaction().begin();
		UsuarioReciclavel usuarioReciclavel = new UsuarioReciclavel();
		usuarioReciclavel.setAtivo(true);
		usuarioReciclavel.setUsuario(user);
		usuarioReciclavel.setReciclavel(oleo);
		usuarioReciclavel = em.merge(usuarioReciclavel);
		em.getTransaction().commit();
		
		/*Criando Oferta */
		em.getTransaction().begin();
		Oferta doacao = new Oferta();
		doacao.setDataOferta(LocalDateTime.now());
		doacao.setTipoOferta(TipoOferta.DOACAO.name());
		doacao.setUsuarioReciclavel(usuarioReciclavel);
		doacao = em.merge(doacao);
		em.getTransaction().commit();
		
	} catch (Exception e) {
		if (em != null && em.getTransaction().isActive()) {
			em.getTransaction().rollback();
		}
		e.printStackTrace();
	} finally{
		if (em != null) {
			em.close();
		}
		System.exit(0);
	}
}
}


