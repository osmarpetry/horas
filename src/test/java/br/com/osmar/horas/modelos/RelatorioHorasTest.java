package br.com.osmar.horas.modelos;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class RelatorioHorasTest {

	@Test
	public void CalculaRelatorioQuandoDatasSaoIguais() {
		// 22-fev-2016
		Calendar data = new GregorianCalendar(2016, 1, 22);
		// 10am até 06pm
		HoraLancada registroHora1 = novaHoraLancada("10:00", "18:00", data);
		// 06pm até 10pm
		HoraLancada registroHora2 = novaHoraLancada("18:00", "20:00", data);
		RelatorioHoras relatorio = new RelatorioHoras(Arrays.asList(registroHora1,registroHora2));
		
        HorasPorDia horasPorDia = relatorio.getHorasPorDia().get(0);
        Assert.assertEquals(1, relatorio.getHorasPorDia().size());
        Assert.assertEquals(8.0, horasPorDia.getHorasNormais(), 0.001);
        Assert.assertEquals(2.0, horasPorDia.getHorasExtras(), 0.001);
        Assert.assertEquals(data, horasPorDia.getData());
		
	}
	
	@Test
	public void CalculaRelatorioQuandoDatasSaoDiferentes() {
		// 22-fev-2016
		Calendar data1 = new GregorianCalendar(2016, 1, 22);
		// 23-fev-2016
		Calendar data2 = new GregorianCalendar(2016, 1, 23);
		// 10am até 06pm
		HoraLancada registroHora1 = novaHoraLancada("10:00", "18:00", data1);
		// 06pm até 10pm
		HoraLancada registroHora2 = novaHoraLancada("10:00", "20:00", data2);
		RelatorioHoras relatorio = new RelatorioHoras(Arrays.asList(registroHora1,registroHora2));
		
		//Vou pegar os dois registroHora, pegar as horas de cada e somar.
		List<HorasPorDia> horasPorDia = relatorio.getHorasPorDia();

		HorasPorDia dia1 = horasPorDia.get(0);
		HorasPorDia dia2 = horasPorDia.get(1);
		
        Assert.assertEquals(2, relatorio.getHorasPorDia().size());
        Assert.assertEquals(8.0, dia1.getHorasNormais(), 0.001);
        Assert.assertEquals(0.0, dia1.getHorasExtras(), 0.001);
        Assert.assertEquals(data1, dia1.getData());

        Assert.assertEquals(8.0, dia2.getHorasNormais(), 0.001);
        Assert.assertEquals(2.0, dia2.getHorasExtras(), 0.001);
        Assert.assertEquals(data2, dia2.getData());
		
	}

	private HoraLancada novaHoraLancada(String horaInicial, String horaFinal, Calendar data) {
		HoraLancada hora = new HoraLancada();
		hora.setData(data);
		hora.setHoraInicial(horaInicial);
		hora.setHoraFinal(horaFinal);
		return hora;
	}
}