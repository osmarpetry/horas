package br.com.osmar.horas.modelos;

import org.junit.Test;

import org.junit.Assert;

public class HoraLancadaTest {
	
	@Test
	public void calculaDuracaoQuandoHoraInicialMenorQueHoraFinal(){
		HoraLancada hora = new HoraLancada();

		hora.setHoraInicial("09:00");
		hora.setHoraFinal("19:00");
		
		//Esperada, getter, erro possível por ser double
		Assert.assertEquals(10.0, hora.getDuracao(), 0.01);
	}
}
