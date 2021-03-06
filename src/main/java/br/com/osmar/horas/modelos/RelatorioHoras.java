package br.com.osmar.horas.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RelatorioHoras {

	private List<HorasPorDia> horasPorDia = new ArrayList<>();

	public RelatorioHoras(List<HoraLancada> horas) {
		calculaHorasPorDia(horas);
	}

	private void calculaHorasPorDia(List<HoraLancada> horas) {
		if (!horas.isEmpty()) {
			double horasDoDia = 0.0;
			Calendar dataAtual = horas.get(0).getData();
			for (HoraLancada hora : horas) {
				// Para validar se mudei de dia
				if (!hora.getData().equals(dataAtual)) {
					// Se trabalhar menos que 8h por dia, vai ser horasPorDia
					double horasNormais = Math.min(horasDoDia, 8.0);

					// Horas que trabalhou - 8
					double horasExtras = Math.max(horasDoDia - 8, 0.0);

					horasPorDia.add(new HorasPorDia(horasNormais, horasExtras, dataAtual));

					// Por ser um for, eu preciso zerar no final de cada for
					dataAtual = hora.getData();
					horasDoDia = 0.0;
				}
				horasDoDia += hora.getDuracao();
			}
			/*
			 * Tenho que jogar fora do for também, porque se todas as horas
			 * estiveram na mesma data, vai dar erro. Daí assim eu evito ele :)
			 */
			double horasNormais = Math.min(horasDoDia, 8.0);
			double horasExtras = Math.max(horasDoDia - 8, 0);
			horasPorDia.add(new HorasPorDia(horasNormais, horasExtras, dataAtual));
		}
	}

	public List<HorasPorDia> getHorasPorDia() {
		return horasPorDia;
	}


}
