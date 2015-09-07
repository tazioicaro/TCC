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

import com.bb.controller.control.repository.filter.PedidoFilter;
import com.bb.models.Pedido;

public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Pedido> pedidosFiltrados(PedidoFilter filtro) {

		Session sessao = manager.unwrap(Session.class);

		Criteria criteria = sessao.createCriteria(Pedido.class)
				.createAlias("cliente", "c").createAlias("vendedor", "v");

		if (filtro.getNumeroDe() != null) {

			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {

			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}
		if (filtro.getDataCriacaoDe() != null) {

			criteria.add(Restrictions.ge("id", filtro.getDataCriacaoDe()));
		}

		if (filtro.getDataCriacaoAte() != null) {

			criteria.add(Restrictions.ge("id", filtro.getDataCriacaoAte()));
		}

		if (StringUtils.isNotBlank(filtro.getNomeCliente())) {

			criteria.add(Restrictions.ilike("c.nome", filtro.getNomeCliente(),
					MatchMode.ANYWHERE));

		}

		if (StringUtils.isNotBlank(filtro.getNomeVendedor())) {

			criteria.add(Restrictions.ilike("v.nome", filtro.getNomeVendedor(),
					MatchMode.ANYWHERE));

		}

		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {

			criteria.add(Restrictions.in("tatus", filtro.getStatuses()));

		}

		return criteria.addOrder(Order.asc("id")).list();

	}

}
