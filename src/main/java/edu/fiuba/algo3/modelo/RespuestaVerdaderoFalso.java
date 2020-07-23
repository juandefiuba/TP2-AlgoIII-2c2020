package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class RespuestaVerdaderoFalso extends Respuesta {

	public RespuestaVerdaderoFalso(String item, Jugador jugador) {
		super(item, jugador);
	}
	
	public RespuestaVerdaderoFalso(ArrayList<String> items, Jugador jugador) {
		super(items, jugador);
	}
	
	protected boolean igualA(Respuesta otraRespuesta) {
		boolean iguales = ( this.items.size() == otraRespuesta.items.size() );
		Iterator<String> iteradorPropio = this.items.iterator();
		Iterator<String> iteradorExt = otraRespuesta.items.iterator();
		return ( iteradorPropio.next() == iteradorExt.next() );
	}
	
	public int comparar(Respuesta otraRespuesta) {
		if(this.igualA(otraRespuesta)) {
			return 1;
		}
		return 0;
	}

	public void calificarJugador(int puntuacion)
	{
		this.jugador.asignarPuntos(puntuacion);
	}
	

}
