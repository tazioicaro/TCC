package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import com.bb.controller.control.repository.filter.DepartamentoFilter;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Departamento;

public class Departamentos2 implements Serializable {

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

	
	
	

	public List<Departamento> todosGerentes() {

		
		 return this.manager.createQuery("from Departamento"
		 + "where departamentoPai is not null", Departamento.class)
		 .getResultList();
		 
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<String> todosGerentesString() {

		
		 return this.manager.createQuery("SELECT distinct d.nome  FROM Departamento d where d.departamentoPai is not null")
		 .getResultList();
		 
		

//		Session session = manager.unwrap(Session.class);	
//
//		Criteria criteria = session.createCriteria(Departamento.class, "d")
//				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		criteria.add(Subqueries.notExists(DetachedCriteria.forClass(Departamento.class, "c")
//				.setProjection(Projections.id()).add(Restrictions.eqProperty("d.codigo", "c.departamentoPai"))
//				));
//
//		return criteria.list();

		/*
		 * Busca todos os departamentos
		 * 
		 * Session session = manager.unwrap(Session.class);
		 * 
		 * Query query = (Query) session.createCriteria(Departamento.class)
		 * .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 * 
		 * List<Departamento> persons = query.list();
		 * 
		 * 
		 * 
		 * return persons;
		 */

		/*
		 * E Assim também
		 * 
		 * Session session = manager.unwrap(Session.class);
		 * 
		 * Criteria criteria = session.createCriteria(Departamento.class);
		 * criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		 * criteria.add(Restrictions.isNotNull("departamentoPai"));
		 * List<Departamento> persons = criteria.list();
		 * 
		 * 
		 * return persons;
		 */

		/*
		 * Funciona na redução de query
		 * 
		 * Session session = manager.unwrap(Session.class);
		 * 
		 * Criteria criteria = session.createCriteria(Departamento.class, "d");
		 * criteria.add(Subqueries.notExists(
		 * DetachedCriteria.forClass(Departamento.class, "c")
		 * .setProjection(Projections.id())
		 * .add(Restrictions.eqProperty("d.codigo", "c.departamentoPai")))) ;
		 * 
		 * return criteria.list();
		 */

		// criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		/*
		 * Vai servir para o Funcionário
		 * 
		 * Consultar todos os alunos que estão matriculados em dois curso (pt e
		 * matema)
		 * 
		 * public List<Aluno> alunosCursandoTodosOsCursos() { Criteria criteria
		 * = session.createCriteria(Aluno.class, "a");
		 * criteria.add(Subqueries.notExists(
		 * DetachedCriteria.forClass(Curso.class, "c")
		 * .setProjection(Projections.id()) .add(Subqueries.notExists(
		 * DetachedCriteria.forClass(Matricula.class, "m")
		 * .setProjection(Projections.id())
		 * .add(Restrictions.eqProperty("m.curso.id", "c.id"))
		 * .add(Restrictions.eqProperty("m.aluno.id", "a.id") )) )); return
		 * criteria.list(); }
		 */

		/*
		 * Collection<Long> groups * Order order int maxResults
		 * 
		 * DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		 * dc.createAlias("groups", "g"); dc.add(Restrictions.in("g.id",
		 * groups); Criteria c = getSession().createCriteria(User.class);
		 * c.add(Property.forName("id").in(dc)); c.addOrder(o);
		 * c.setMaxResults(maxResults); return c.list();
		 */

	}

	public Departamento porNome(String nome) {

		return this.manager.createQuery("from Departamento where lower(nome) =:nome", Departamento.class)
				.setParameter("nome", nome.toLowerCase()).getSingleResult();
	}

	public List<Departamento> porGerente(Departamento departamentoPai) {
		return manager.createQuery("from Departamento where departamentoPai = :raiz", Departamento.class)
				.setParameter("raiz", departamentoPai).getResultList();
	}

	@Transactional
	public Departamento guardar(Departamento departamento) {

		return this.manager.merge(departamento);
	}

	public void removerDepartamento(Departamento departamentoSelecionado) {

		manager.remove(manager.contains(departamentoSelecionado) ? departamentoSelecionado
				: manager.merge(departamentoSelecionado));

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

}