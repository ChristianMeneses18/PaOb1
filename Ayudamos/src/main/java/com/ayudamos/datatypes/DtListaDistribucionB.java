package com.ayudamos.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;


@XmlRootElement(name = "dtListaDistribucion") 
@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaDistribucionB {
	@XmlElement(name = "lista")
	private ArrayList<DtDistribucionBeneficiario> lista;
	
	
	public DtListaDistribucionB() {}
	
	public DtListaDistribucionB(ArrayList<DtDistribucionBeneficiario> lista){
		this.lista = lista;
	}
	
	public ArrayList<DtDistribucionBeneficiario> getLista() {
		return lista;
	}	
}
