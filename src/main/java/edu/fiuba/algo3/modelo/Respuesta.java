package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Respuesta {
	
	protected Collection<String> items;
	
	public Respuesta(String item) {
		this.items = new ArrayList<String>();
		this.items.add(item);
	}
	
	public Respuesta(ArrayList<String> items) {
		this.items = new ArrayList<String>();
		this.items.addAll(items);
	}
	
	protected abstract boolean igualA(Respuesta otraRespuesta);
	
	public abstract int comparar(Respuesta otraRespuesta);

}
