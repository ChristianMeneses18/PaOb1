package com.ayudamos.excepciones;

public class DistribucionRepetidaExcepcion extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DistribucionRepetidaExcepcion(String string) {
        super(string);
    }

}
