package br.com.fiap.reciclamais.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.reciclamais.domain.Bairro;

public class BairroDAO extends GenericDAO<Bairro, Integer>{

	public BairroDAO(EntityManager em) {
		super(em);
	}
	
	/*consulta simples que equivale ao select * from tabela sobrescrevendo o método listar da GenericDAO */
	
	@Override
	public List <Bairro> listar(){
		return em.createQuery("from Bairro").getResultList();
	}
	
	/*consulta ordenada com um novo método listarOrdenadNome2(). obs: caso fossem necessários os 3 ultimos registros da tabela, o from seria: "from Bairro order by id desc", e temos o .setMaxResults(3) pois assim os IDS seriam listados dos mais novos para os mais velhos */
	
	public List<Bairro> listarOrdenadoNome(){
		return em.createQuery("from Bairro order by nome, id desc", Bairro.class).getResultList();
	}
	
	public List<Bairro> listarOrdenadoNomeMaximo3(){
		return em.createQuery("from Bairro order by id desc", Bairro.class).setMaxResults(3).getResultList();
	}
	
	public List<Bairro>
	listarPaginado(int itensPorPagina, int pagina){
		
		int primeiro = (pagina - 1 ) * itensPorPagina;
		return em.createQuery("from Bairro order by nome").setMaxResults(itensPorPagina)
				.setFirstResult(primeiro)
				.getResultList();
		
	}
}
