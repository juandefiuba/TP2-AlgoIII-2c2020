package edu.fiuba.algo3.controlador;

import java.util.LinkedList;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ManejadorDeOpcionesDesordenadas implements EventHandler<ActionEvent> {

	private LinkedList<Opcion> respuesta;
	private Opcion opcion;
	//private Cosa desordenadas;
	
	public ManejadorDeOpcionesDesordenadas(LinkedList<Opcion> respuesta, Opcion opcion/*, Cosa desordenadas*/) {
		this.respuesta = respuesta;
		this.opcion = opcion;
		//this.desordenadas = desordenadas;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.respuesta.remove(this.opcion);
		//this.desordenadas.actualizar();
	}

}
