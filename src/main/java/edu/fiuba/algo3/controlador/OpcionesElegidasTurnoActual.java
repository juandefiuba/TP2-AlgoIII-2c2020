package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Iterator;

public class OpcionesElegidasTurnoActual implements EventHandler<ActionEvent> {
	;
	private final Kahoot kahoot;
	private Iterator<Opcion> puntero;

	public OpcionesElegidasTurnoActual(Kahoot kahoot, Iterator<Opcion> puntero) {
		this.kahoot = kahoot;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.puntero = this.kahoot.getOpcionesElegidasTurnoActual();
	}

}
