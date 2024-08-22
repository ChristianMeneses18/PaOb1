package com.ayudamos.datatypes;


public class DtFechaHora {
	private int dia;
	private int mes;
	private int anio;
	private int hora;
	private int minuto;
	
	public DtFechaHora(int dia, int mes, int anio, int hora, int minuto) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.hora = hora;
		this.minuto = minuto;
	}
	
	public int getDia(){
		return dia;
	}
	
	public int getMes(){
		return mes;
	}

	public int getAnio(){
		return anio;
	}
	
	public int getHora(){
		return hora;
	}
	
	public int getMinuto(){
		return minuto;
	}
	
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + anio + " " + hora + ":" + minuto;
	}
}
