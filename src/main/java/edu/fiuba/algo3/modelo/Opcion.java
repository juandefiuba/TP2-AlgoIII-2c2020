package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Correcto;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Estado;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Incorrecto;

public class Opcion {
	
	private Estado valor;
	private Natural posicion; /* para pregunta tipo OrderChoice */
	
	public Opcion() {
		valor = new Incorrecto();
	}
	
	public void definirCorrecta() {
		valor = new Correcto();
	}
	
	public void definirIncorrecta() {
		valor = new Incorrecto();
	}
	
	public Boolean mismoValor(Opcion otraOpcion) {
		return this.valor.esCorrecta() == otraOpcion.valor.esCorrecta();
	}
	
	public Boolean esCorrecta() {
		return (this.valor.esCorrecta());
	}

}
