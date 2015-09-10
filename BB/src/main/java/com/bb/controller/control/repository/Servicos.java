package com.bb.controller.control.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.bb.controller.control.repository.filter.ServicoFilter;
import com.bb.models.Servico;

public class Servicos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Servico> pedidosFiltrados(ServicoFilter filtro) {

		Session sessao = manager.unwrap(Session.class);

		Criteria criteria = sessao.createCriteria(Servico.class)
				.createAlias("cliente", "c").createAlias("funcionario", "v");

		if (filtro.getNumeroDe() != null) {

			criteria.add(Restrictions.ge("codigo", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {

			criteria.add(Restrictions.le("codigo", filtro.getNumeroAte()));
		}
		if (filtro.getDataCriacaoDe() != null) {

			criteria.add(Restrictions.ge("dataCriacao", filtro.getDataCriacaoDe()));
		}

		if (filtro.getDataCriacaoAte() != null) {

			criteria.add(Restrictions.ge("dataCriacao", filtro.getDataCriacaoAte()));
		}

		if (StringUtils.isNotBlank(filtro.getNomeCliente())) {

			criteria.add(Restrictions.ilike("c.nome", filtro.getNomeCliente(),
					MatchMode.ANYWHERE));

		}

		if (StringUtils.isNotBlank(filtro.getNomeVendedor())) {

			criteria.add(Restrictions.ilike("v.nome", filtro.getNomeVendedor(),
					MatchMode.ANYWHERE));

		}

		if (filtro.getStatusServicoes() != null && filtro.getStatusServicoes().length > 0) {

			criteria.add(Restrictions.in("statusServico", filtro.getStatusServicoes()));

		}

		return criteria.addOrder(Order.asc("codigo")).list();

	}

}
