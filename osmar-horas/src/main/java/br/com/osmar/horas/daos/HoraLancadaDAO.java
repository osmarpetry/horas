package br.com.osmar.horas.daos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.osmar.horas.modelos.HoraLancada;

public class HoraLancadaDAO {

	private EntityManager manager;

	@Inject
	public HoraLancadaDAO(EntityManager manager) {
		this.manager = manager;
	}

	public HoraLancadaDAO() {}

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

}