package br.com.osmar.horas.seguranca;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.osmar.horas.controllers.LoginController;

@Intercepts
public class AutorizacaoInterceptor {

	private UsuarioLogado usuarioLogado;
	private Result result;
	private ControllerMethod method;

	public AutorizacaoInterceptor() {}
	
	@Inject
	public AutorizacaoInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod method) {
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.method = method;
	}

	/*
	 * È um metodo do @Intercepts, se retornar true vai ser executado então se o
	 * controller tiver @Open (criei), não quero executar, mas para eu saber se
	 * um methodo está anotado preciso do ControllerMethod
	 */
	@Accepts
	public boolean accept() {
		return !method.containsAnnotation(Open.class);
		// Se tiver retorna true, por isso !. Preciso que seja false para não
		// passar pelo accept
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		if (usuarioLogado.isLogado()) {
			stack.next();
		} else {
			result.redirectTo(LoginController.class).form();
		}
	}
}
