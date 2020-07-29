package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Verdadero;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Estado;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Falso;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public class Opcion {
	
	private Estado valor;
	private Natural posicion; /* para pregunta tipo OrderChoice */
	
	public Opcion() {
		valor = new Falso();
	}
	
	public void definirCorrecta() {
		valor = new Verdadero();
	}
	
	public void definirIncorrecta() {
		valor = new Falso();
	}
	
	public EstadoDeRespuesta mismoValor(Opcion otraOpcion) {
		return this.valor.esCorrecta(otraOpcion.valor);
	}
	
	public Estado esCorrecta() {
		return this.valor;
	}

}
