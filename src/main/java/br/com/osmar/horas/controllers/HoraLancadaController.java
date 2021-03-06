package br.com.osmar.horas.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.osmar.horas.daos.HoraLancadaDAO;
import br.com.osmar.horas.modelos.HoraLancada;
import br.com.osmar.horas.modelos.RelatorioHoras;
import br.com.osmar.horas.seguranca.UsuarioLogado;

@Controller
public class HoraLancadaController {

	private HoraLancadaDAO dao;
	private Validator validator;
	private Result result;
	private UsuarioLogado usuarioLogado;

	// meuDaoParaPersistencia, paraValidacao, controlarResultQueVaiParaUser
	@Inject // Usando CDI para injeção de dep.
	public HoraLancadaController(HoraLancadaDAO dao, 
			Validator validator, Result result, UsuarioLogado usuarioLogado) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
		this.usuarioLogado = usuarioLogado;

	}

	// Por causa do @Inject
	public HoraLancadaController() {
	}

	public void form() {
	}

	// @Valid ser validada pelo bean
	public void adiciona(@Valid HoraLancada horaLancada) {
		validator.onErrorRedirectTo(this).form();
		horaLancada.setUsuario(usuarioLogado.getUsuario());
		dao.adiciona(horaLancada);
		result.redirectTo(this).lista();
	}

	public void lista() {
		result.include("horas", dao.lista());
	}

	public void relatorioDeHoras() {
		List<HoraLancada> horas = dao.horasDoUsuario(usuarioLogado.getUsuario());
		//Por ser muito complexo, vou fazer separado. Pois o usuário pode ter vários registros durante o dia por exemplo
		RelatorioHoras relatorioHoras = new RelatorioHoras(horas);
		result.include("relatorio", relatorioHoras);
		
	}
}
