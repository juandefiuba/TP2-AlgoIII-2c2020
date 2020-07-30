package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NumeroMenorAUnoException;

public class Natural {

	private int numero;
	
	public Natural(int numero) throws NumeroMenorAUnoException {
		if(numero < 1) {
			throw new NumeroMenorAUnoException();
		} else {
			this.numero = numero;
		}
	}
	
	public int getNumero() {
		return this.numero;
	}
	
}
