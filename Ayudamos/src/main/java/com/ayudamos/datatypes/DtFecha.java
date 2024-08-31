package com.ayudamos.datatypes;




public class DtFecha {
	private int dia;
	private int mes;
	private int anio;
	
	public DtFecha() {
    }
	
	public DtFecha(int dia, int mes, int anio){
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
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
	
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + anio;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DtFecha dtFecha = (DtFecha) o;

        if (dia != dtFecha.dia) return false;
        if (mes != dtFecha.mes) return false;
        return anio == dtFecha.anio;
    }

    @Override
    public int hashCode() {
        int result = dia;
        result = 31 * result + mes;
        result = 31 * result + anio;
        return result;
    }
}
