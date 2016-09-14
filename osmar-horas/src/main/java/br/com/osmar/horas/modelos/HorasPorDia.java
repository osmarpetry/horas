package br.com.osmar.horas.modelos;

import java.util.Calendar;

public class HorasPorDia {

	private double horasNormais;
	private double horasExtras;
	private Calendar data;

	public HorasPorDia(double horasNormais, double horasExtras, Calendar data){
		this.horasNormais = horasNormais;
		this.horasExtras = horasExtras;
		this.data = data;
	}

	public double getHorasNormais() {
		return horasNormais;
	}

	public double getHorasExtras() {
		return horasExtras;
	}

	public Calendar getData() {
		return data;
	}
	
}
