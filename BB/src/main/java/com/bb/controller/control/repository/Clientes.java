package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.bb.controller.control.repository.filter.ClienteFilter;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Cliente;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manage;
	
	
	public Cliente porId (Long id){
		
		return manage.find(Cliente.class, id);
	}
	
	public List<Cliente> porNome (String nome){
		
		
		return this.manage.createQuery("from Cliente where upper(name) like=:nome", Cliente.class)
				.setParameter("nome", nome.toLowerCase() + "%").getResultList();
		
		
	}
	
	public Cliente consultarNome (String nome){
		try {
			return this.manage.createQuery("from Cliente where upper(nome) =:nome", Cliente.class)
				.setParameter("nome",nome.toLowerCase()).getSingleResult();
		} catch(NoResultException e){
			
			//Inserir tratamento da excessão
		}
		return null;
	}
	
	public Cliente porEmail (String email){
		
		try{
			return this.manage.createQuery("from Cliente  where upper (email) =:email", Cliente.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();
			
		}catch(NoResultException e){
			
		}
		return null;
	}
	
	
	
	public Cliente porDocIdentificacao (String documentoReceitaFederal){
		
		try{
			return this.manage.createQuery("from Cliente where upper (documentoReceitaFederal) =:documentoReceitaFederal", Cliente.class)
					.setParameter("documentoReceitaFederal", documentoReceitaFederal.toLowerCase()).getSingleResult();
		}catch(NoResultException e){
			
		}
		
		return null;
	}

	
	
	private Criteria criarCriteriosParaFiltros (ClienteFilter filtro){
		
		Session session = manage.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Cliente.class);
		
		if(StringUtils.isNoneBlank(filtro.getNome())){
			criteria.add(Restrictions.ilike("nome", filtro.getNome()));
		}
		
		if (StringUtils.isNotEmpty(filtro.getDocumentoReceitaFederal())){
			criteria.add(Restrictions.eq("documentoReceitaFederal", filtro.getDocumentoReceitaFederal()));
		}
		
		return criteria;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> filtrados(ClienteFilter filtro) {
		
		Criteria criteria = criarCriteriosParaFiltros(filtro);
		
		criteria.setFirstResult(filtro.getPrimeiroRegistro());
		criteria.setMaxResults(filtro.getQuantidadeRegistros());
		
		if(filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null){
			criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));
		}else if ( filtro.getPropriedadeOrdenacao() != null){
			criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));
		}
		
	
		return criteria.list();
		
		
	}
	
public int quantidadeFiltrados(ClienteFilter filtro) {
		
		Criteria criteria = criarCriteriosParaFiltros(filtro);
		
		criteria.setProjection(Projections.rowCount());
		
	
		return ((Number) criteria.uniqueResult()).intValue();
	}


@Transactional
public Cliente guardar (Cliente cliente){
	return manage.merge(cliente);
}

public void removerCliente(Cliente clienteSelecionado) {
	manage.remove(clienteSelecionado);
	
}
	
}
