package com.ayudamos.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;


@XmlRootElement(name = "dtListaDistribucion") 
@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaDistribucion {
	@XmlElement(name = "lista")
	private ArrayList<DtDistribucion> lista;
	
	
	public DtListaDistribucion() {}
	
	public DtListaDistribucion(ArrayList<DtDistribucion> lista){
		this.lista = lista;
	}
	
	public ArrayList<DtDistribucion> getLista() {
		return lista;
	}	
}