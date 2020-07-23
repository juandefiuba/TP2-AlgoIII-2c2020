package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class RespuestaVerdaderoFalso extends Respuesta {

	public RespuestaVerdaderoFalso(String item) {
		super(item);
	}
	
	protected boolean igualA(Respuesta otraRespuesta) {
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
	

}
