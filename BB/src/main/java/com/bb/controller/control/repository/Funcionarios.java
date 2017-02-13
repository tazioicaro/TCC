package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.bb.controller.control.repository.filter.FuncionarioFilter;
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
	
	@Transactional
	public Funcionario guardar (Funcionario funcionario){
		return this.manage.merge(funcionario);
	}
	
	public void remover(Funcionario funcionario){
		manage.remove(funcionario);
		
	}
	
	
	public Criteria criarCriteriaParaFiltro(FuncionarioFilter filter){
		
		Session session = manage.unwrap(Session.class);
		
		//Confirmar se existe grupos no banco
		Criteria criteria = session.createCriteria(Funcionario.class).createAlias("Grupos", "gp");
		
		if(StringUtils.isNotBlank(filter.getNome())){
			criteria.add(Restrictions.eq("nome", filter.getNome()));
		}
		
		if(filter.getGrupos()!= null && filter.getGrupos().size() > 0){
			criteria.add(Restrictions.in("gp.descricao", filter.getGrupos()));
		}
		
		
		
		return criteria;
		
	}
	
	
	public List<Funcionario> filtrados (FuncionarioFilter filter){
		
		
		return null;
		
	}
	

}
