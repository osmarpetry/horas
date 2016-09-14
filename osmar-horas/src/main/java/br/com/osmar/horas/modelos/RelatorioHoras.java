package br.com.osmar.horas.modelos;

import java.util.ArrayList;
import java.util.List;

public class RelatorioHoras {

	private List<HoraLancada> horas;
	private List<HorasPorDia> horasPorDia = new ArrayList<>();

	public RelatorioHoras(List<HoraLancada> horas){
		this.horas = horas;
	}

	public List<HorasPorDia> getHorasPorDia() {
		return horasPorDia;
	}

}
