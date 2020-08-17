package edu.fiuba.algo3.controlador.OrderedChoice;

import java.util.LinkedList;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
		this.respuesta.add(this.opcion);
		// TODO: cambiar escena?
		//this.desordenadas.actualizar();
	}

}
