package br.com.osmar.horas.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.osmar.horas.daos.UsuarioDAO;
import br.com.osmar.horas.modelos.Usuario;
import br.com.osmar.horas.seguranca.Open;
import br.com.osmar.horas.seguranca.UsuarioLogado;

@Controller
public class LoginController {

	private UsuarioDAO usuarioDAO;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;

	public LoginController() {}

	@Inject
	public LoginController(UsuarioDAO usuarioDAO, UsuarioLogado usuarioLogado, 
			Result result, Validator validator) {
		this.usuarioDAO = usuarioDAO;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}

	@Open
	public void form() {
	}

	@Open
	public void autentica(String login, String senha) {
		Usuario usuario = usuarioDAO.busca(login, senha);
		if (usuario != null) {
			usuarioLogado.fazLogin(usuario);
			result.redirectTo(IndexController.class).index();
		} else {
			validator.add(new SimpleMessage("login_invalido", "Login ou senha incorretos"));
			validator.onErrorUsePageOf(this).form();
		}
	}

	@Open
	public void desloga() {
		usuarioLogado.desloga();
		result.redirectTo(this).form();
	}
}
