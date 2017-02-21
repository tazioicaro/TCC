package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.JoinType;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.bb.controller.control.repository.filter.FuncionarioFilter;
import com.bb.controller.services.NegocioException;
import com.bb.controller.util.jpa.Transactional;
import com.bb.models.Funcionario;

public class Funcionarios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manage;
	
	
	public Funcionario porID(Long id){
		
		return manage.find(Funcionario.class, id);
	}
	
	public List<Funcionario> vendedores(){
		
		return manage.createQuery("from funcionario", Funcionario.class).getResultList();
		
	}
	
	
	public Funcionario porNome(String nome){
		
		Funcionario funcionario = null;
		
		try{
			funcionario = manage.createQuery("from Funcionario where lower(nome) =:nome", Funcionario.class)
			.setParameter("nome", nome.toLowerCase()).getSingleResult();
		}catch(NoResultException ne){			
			
		}
		
		return funcionario;
		
	}
	
	

	public Object porLogin(String login) {
		
		Funcionario funcionario = null;
		
		try{
			funcionario = manage.createQuery("from Funcionario where lower(login) =:login " , Funcionario.class)
					.setParameter("login", login.toLowerCase()).getSingleResult();
		}catch(NoResultException ne){
			
		}
		
		return funcionario;
	}
	
	
	public Funcionario porCPF (String cpf){
		
		Funcionario funcionario = null;
		
		try{
			funcionario = manage.createQuery("from Funcionario where  lower(cpf) =:cpf", Funcionario.class)
					.setParameter("cpf",cpf.toLowerCase()).getSingleResult();
		}catch(NoResultException ne){
			
		}
		
		return funcionario;
		
	}
	
	@Transactional
	public Funcionario guardar (Funcionario funcionario){
		return this.manage.merge(funcionario);
	}
	
	
	@Transactional
	public void remover(Funcionario funcionario){
		try{
			//As vezes o objeto perde a instancia com o manager e passa a ser detached. então é necessário fazer
			// um merge para ele ficar realltach
			manage.remove(manage.contains(funcionario) ? funcionario : manage.merge(funcionario));
	
		} catch(PersistenceException e){
			
			throw new NegocioException("Funcionário não pode ser excluído!");
			
		}
		
	}
	
	
	public Criteria criarCriteriaParaFiltro(FuncionarioFilter filter){
		
		Session session = manage.unwrap(Session.class);	
		
		Criteria criteria = session.createCriteria(Funcionario.class)
				.createAlias("grupos", "gp");
		
		if(StringUtils.isNotBlank(filter.getNome())){
			criteria.add(Restrictions.eq("nome", filter.getNome()));
		}
		
		if(filter.getGrupos()!= null && filter.getGrupos().size() > 0){
			criteria.add(Restrictions.in("gp.descricao", filter.getGrupos()));
		}			
		
		return criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		//
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> filtrados (FuncionarioFilter filter){
		
		Criteria criteria = criarCriteriaParaFiltro(filter);		
		criteria.setFirstResult(filter.getPrimeiroRegistro());
		criteria.setMaxResults(filter.getQtdeRequistros());
		
		if (filter.isAscendente() && filter.getPropriedadeOrdenacao() != null){
			criteria.addOrder(Order.asc(filter.getPropriedadeOrdenacao()));
		} else if (filter.getPropriedadeOrdenacao() != null){
			criteria.addOrder(Order.desc(filter.getPropriedadeOrdenacao()));
			
		}
		
		return criteria.list();
		
	}
	
	public int quantidadeFiltrados(FuncionarioFilter filter){
		Criteria criteria = criarCriteriaParaFiltro(filter);
		criteria.setProjection(Projections.rowCount());
		return ((Number) criteria.uniqueResult()).intValue();
	}

	

}
