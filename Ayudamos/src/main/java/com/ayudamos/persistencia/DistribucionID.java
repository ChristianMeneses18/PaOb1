package com.ayudamos.persistencia;

import java.io.Serializable;

public class DistribucionID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String beneficiario;  
    private int donacion; 
	
	public DistribucionID() {
		super();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + donacion;
		result = prime * result + ((beneficiario == null) ? 0 : beneficiario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistribucionID other = (DistribucionID) obj;
		if (donacion != other.donacion)
			return false;
		if (beneficiario == null) {
			if (other.beneficiario != null)
				return false;
		} else if (!beneficiario.equals(other.beneficiario))
			return false;
		return true;
	}


	public String getBeneficiario() {
		return beneficiario;
	}


	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}


	public int getDonacion() {
		return donacion;
	}


	public void setDonacion(int donacion) {
		this.donacion = donacion;
	}

}
