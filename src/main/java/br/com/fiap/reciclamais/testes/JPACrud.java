package br.com.fiap.reciclamais.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.reciclamais.domain.Endereco;
import br.com.fiap.reciclamais.domain.Reciclavel;
import br.com.fiap.reciclamais.domain.TipoDocumento;
import br.com.fiap.reciclamais.domain.TipoUsuario;
import br.com.fiap.reciclamais.domain.Usuario;

public class JPACrud { public static void main(String[] args) {
	EntityManager em = null;
	try {
		em = Persistence.createEntityManagerFactory("jpahibernate").createEntityManager();
		
		/*Localizando e alterando o usuário */
		em.getTransaction().begin();		
		Usuario recuperado = 
				em.find(Usuario.class, 8);
		
		recuperado.setNome("Condominio das Pedras");
		
		System.out.println(recuperado.getNome());
		em.merge(recuperado);
		em.getTransaction().commit();
		
		/*Criando e Deletando o usuario*/
		
		/*Criando Usuário */
		em.getTransaction().begin();
		Usuario user2 = new Usuario();
		user2.setDocumento("11111111111111");
		user2.setTipoDocumento(TipoDocumento.CNPJ.name());
		user2.setEmail("condominioY@gmail.com");
		user2.setSenha("123456");
		user2.setNome("Condominio Y");
		user2.setEndereco(em.find(Endereco.class,"03232000" ));
		user2.setTelefone("55553333");
		user2.setTipo(TipoUsuario.CONDOMINIO.name());
		user2 = em.merge(user2);
		em.getTransaction().commit();
		
		
		em.getTransaction().begin();		
		
		em.remove(user2);
		
		em.getTransaction().commit();
		
		/*Localizando e alterando um reciclavel (finding and updating) */
		em.getTransaction().begin();
		Reciclavel recuperado3 = 
				em.find(Reciclavel.class, 2);
		
		recuperado3.setNome("Papelão");
		System.out.println(recuperado3.getNome());
		em.merge(recuperado3);
		em.getTransaction().commit();
		
		
		/*Criando e deletando um reciclável  */
		
		em.getTransaction().begin();
		Reciclavel lataAluminio= new Reciclavel();
		lataAluminio.setNome("Latinha de Aluminio");
		lataAluminio = em.merge(lataAluminio);
		em.getTransaction().commit();
		
		em.getTransaction().begin();	
		
		em.remove(lataAluminio);
		
		em.getTransaction().commit();
		
		
		/*Criando Endereço*/
		em.getTransaction().begin();
		Endereco end = new Endereco();
		end.setBairro(utinga);
		end.setCep("02921000");
		end.setLogradouro("avenida carvalho");
		end = em.merge(end);
		em.getTransaction().commit();
		
		/*Criando Usuário */
		em.getTransaction().begin();
		Usuario user3 = new Usuario();
		user3.setDocumento("22222222222000122");
		user3.setTipoDocumento(TipoDocumento.CNPJ.name());
		user3.setEmail("condominioX@gmail.com");
		user3.setSenha("12345");
		user3.setNome("Condominio X");
		user3.setEndereco(end);
		user3.setTelefone("44444444");
		user3.setTipo(TipoUsuario.CONDOMINIO.name());
		user3 = em.merge(user);
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

		
	
