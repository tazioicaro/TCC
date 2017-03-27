package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.bb.controller.control.repository.filter.DepartamentoFilter;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Departamento;

public class Departamentos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Departamento> porDepartamento() {

//		return this.manager.createQuery("from Departamento where departamentoPai is null", Departamento.class)
//				.getResultList();
		
		
		Session session = manager.unwrap(Session.class);
		  
		  Criteria criteria = session.createCriteria(Departamento.class);
		  criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		  criteria.add(Restrictions.isNull("departamentoPai"));		  
		  return criteria.list();
		 
	}	
	

	@SuppressWarnings("unchecked")
	public List<Departamento> todosGerentes() {

		
		Session session = manager.unwrap(Session.class);
		  
		  Criteria criteria = session.createCriteria(Departamento.class);
		  criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		  criteria.add(Restrictions.isNotNull("departamentoPai")); 
		
		 return criteria.list();
		 
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<String> todosGerentesString() {

		
		 return this.manager.createQuery("SELECT distinct d.nome  "
		 		+ "FROM Departamento d where d.departamentoPai is not null")
		 .getResultList();
	}
		 
		

	public Departamento porNome(String nome) {

		return this.manager.createQuery("from Departamento where lower(nome) =:nome", Departamento.class)
				.setParameter("nome", nome.toLowerCase()).getSingleResult();
	}

	public List<Departamento> porGerente(Departamento departamentoPai) {
		return manager.createQuery("from Departamento where departamentoPai = :raiz", Departamento.class)
				.setParameter("raiz", departamentoPai).getResultList();
	}


	public Departamento porId(Long valor) {

		return this.manager.find(Departamento.class, valor);
	}

	public Criteria criarCriteriaParaFiltro(DepartamentoFilter filtro) {

		Session session = manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Departamento.class);

		if (StringUtils.isNoneBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		criteria.add(Restrictions.isNull("departamentoPai"));

		return criteria;

	}

	public int quantidadeFiltrados(DepartamentoFilter filtro) {

		Criteria criteria = criarCriteriaParaFiltro(filtro);

		criteria.setProjection(Projections.rowCount());

		return ((Number) criteria.uniqueResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Departamento> filtrados(DepartamentoFilter filtro) {

		Criteria criteria = criarCriteriaParaFiltro(filtro);
		criteria.setFirstResult(filtro.getPrimeiroRegistro());
		criteria.setMaxResults(filtro.getQuantidadeRegistros());

		if (filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null) {
			criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));

		} else if (filtro.getPropriedadeOrdenacao() != null) {
			criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));

		}

		return criteria.list();
	}
/*
 * Criteria para Gerentes

	
	public Criteria criarCriteriaParaFiltroGerentes(DepartamentoFilter filtro) {

		Session session = manager.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Departamento.class);
		
		

		if (StringUtils.isNoneBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		criteria.add(Restrictions.isNotNull("departamentoPai"));
		return criteria;

	}
	
	
	public int quantidadeFiltradosGerentes(DepartamentoFilter filtro) {

		Criteria criteria = criarCriteriaParaFiltroGerentes(filtro);

		criteria.setProjection(Projections.rowCount());

		return ((Number) criteria.uniqueResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Departamento> filtradosGerentes(DepartamentoFilter filtro) {

		Criteria criteria = criarCriteriaParaFiltroGerentes(filtro);
		criteria.setFirstResult(filtro.getPrimeiroRegistro());
		criteria.setMaxResults(filtro.getQuantidadeRegistros());

		if (filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null) {
			criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));

		} else if (filtro.getPropriedadeOrdenacao() != null) {
			criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));

		}


		return criteria.list();
	}
	
	 */

	

	@Transactional
	public Departamento guardar(Departamento departamento) {

		return this.manager.merge(departamento);
	}
	
	/*@Transactional
	public void removerDepartamento(Departamento departamentoSelecionado) {

		manager.remove(manager.contains(departamentoSelecionado) ? departamentoSelecionado
				: manager.merge(departamentoSelecionado));

	}*/
	@Transactional
	public void removerDepartamento(Departamento departamentoSelecionado) {
		manager.remove(porId(departamentoSelecionado.getCodigo()));

	}

}