package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ColeccionDeOpciones {
	
	private ArrayList<Opcion> opciones;
	
	public ColeccionDeOpciones(Integer cantidadOpciones) {
		this.opciones = new ArrayList<Opcion>();
		for(int i = 1; i <= cantidadOpciones; i++) {
			this.opciones.add( new Opcion() );
		}
	}
	
	public Integer size() {
		return this.opciones.size();
	}
	
	private void verificarPosicionValida(int posicion) throws PosicionInvalidaException {
		if( ( posicion < 1 ) || ( posicion > this.opciones.size() ) ) {
			throw new PosicionInvalidaException();
		}
	}
	
	public Opcion get(Integer posicion) {
		this.verificarPosicionValida(posicion);
		Integer index = posicion - 1;
		return this.opciones.get(index);
	}
	
	public void tildarOpcion(Integer posicion) {
		this.verificarPosicionValida(posicion);
		Integer index = posicion - 1;
		this.opciones.get(index).definirCorrecta();
	}
	

}
