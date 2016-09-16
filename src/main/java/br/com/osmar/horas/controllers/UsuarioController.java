package br.com.osmar.horas.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.osmar.horas.daos.UsuarioDAO;
import br.com.osmar.horas.modelos.Usuario;

@Controller
public class UsuarioController {
	private Result result;

	private UsuarioDAO usuarioDAO;

	private Validator validator;

	public UsuarioController() {
	}

	@Inject
	public UsuarioController(Result result, UsuarioDAO usuarioDAO, Validator validator) {
		this.result = result;
		this.usuarioDAO = usuarioDAO;
		this.validator = validator;
	}

	public void form() {
	}

	@IncludeParameters
	@Post
	public void adiciona(@Valid Usuario usuario) {
		validator.onErrorRedirectTo(this).form();
		usuarioDAO.adiciona(usuario);
		result.redirectTo(this).lista();
	}

	public void lista() {
		result.include("usuarios", usuarioDAO.lista());
	}
}