package br.com.osmar.horas.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.osmar.horas.modelos.HoraLancada;
import br.com.osmar.horas.modelos.Usuario;

public class HoraLancadaDAO {

	private EntityManager manager;

	@Inject
	public HoraLancadaDAO(EntityManager manager) {
		this.manager = manager;
	}

	public HoraLancadaDAO() {
	}

	public List<HoraLancada> lista() {
		String jqpl = "select h from HoraLancada h";
		TypedQuery<HoraLancada> query = manager.createQuery(jqpl, HoraLancada.class);
		return query.getResultList();
	}

	public void adiciona(HoraLancada horaLancada) {
		manager.getTransaction().begin();
		manager.persist(horaLancada);
		manager.getTransaction().commit();
	}

	public List<HoraLancada> horasDoUsuario(Usuario usuario) {
		String jpql = "select h from HoraLancada h "
				+ "where h.usuario = :usuario "
				+ "order by h.data";
		TypedQuery<HoraLancada> query = manager.createQuery(jpql, HoraLancada.class);
		query.setParameter("usuario", usuario);
		return query.getResultList();
	}

}
