package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class RespuestaVerdaderoFalso extends Respuesta {

	public RespuestaVerdaderoFalso(String item) {
		super(item);
	}
	
	public RespuestaVerdaderoFalso(ArrayList<String> items) {
		super(items);
	}
	
	public boolean igualA(Respuesta otraRespuesta) {
		boolean iguales = ( this.items.size() == otraRespuesta.items.size() );
		Iterator<String> iteradorPropio = this.items.iterator();
		Iterator<String> iteradorExt = otraRespuesta.items.iterator();
		while( (iguales) && (iteradorPropio.hasNext()) ) {
			iguales = ( iteradorPropio.next() == iteradorExt.next() );
		}
		return iguales;
	}
	
	public int comparar(Respuesta otraRespuesta) {
		if(this.igualA(otraRespuesta)) {
			return 1;
		}
		return 0;
	}
	

}
