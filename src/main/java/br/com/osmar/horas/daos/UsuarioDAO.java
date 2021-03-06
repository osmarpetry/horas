package br.com.osmar.horas.daos;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.osmar.horas.modelos.Usuario;

@RequestScoped
public class UsuarioDAO {
	private EntityManager manager;

	public UsuarioDAO() {
	}

	@Inject
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void adiciona(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}

	public List<Usuario> lista() {
		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

	public Usuario busca(String login, String senha) {
		try {
		TypedQuery<Usuario> query = manager
				.createQuery("select u from Usuario u " + "where u.login = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		return query.getSingleResult();
		} catch (Exception e){
			return null;
		}
	}
}