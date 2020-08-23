package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.*;

import java.util.LinkedList;

public class Factory {
	//Patrón factory
	public Opcion crearOpcion(String tipoOpcion, String textoOpcion) {
		if (tipoOpcion == null) return null;
		Opcion opcion = null;

		if (tipoOpcion.equalsIgnoreCase("C")) {
			opcion = new OpcionCorrecta();
		} else if (tipoOpcion.equalsIgnoreCase("I")) {
			opcion = new OpcionIncorrecta();
		} else if (tipoOpcion.equalsIgnoreCase("O")){
			opcion = new OpcionOrdenada();
		}

		if (opcion != null) opcion.setearTexto(textoOpcion);
		return opcion;
	}

	//Patrón factory
	public PreguntaBase crearPregunta(String tipoPregunta, String textoPregunta, LinkedList<Opcion> opciones){
		if (tipoPregunta == null) return null;
		PreguntaBase pregunta = null;

		if (tipoPregunta.equalsIgnoreCase("VFC")){
			pregunta = new PreguntaVerdaderoFalso(opciones);
		} else if (tipoPregunta.equalsIgnoreCase("VFP")){
			pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);
		} else if (tipoPregunta.equalsIgnoreCase("MCC")){
			pregunta = new PreguntaMultipleChoiceClasico(opciones);
		} else if (tipoPregunta.equalsIgnoreCase("MCPA")){
			pregunta = new PreguntaMultipleChoiceParcial(opciones);
		} else if (tipoPregunta.equalsIgnoreCase("MCPE")){
			pregunta = new PreguntaMultipleChoicePenalidad(opciones);
		} else if (tipoPregunta.equalsIgnoreCase("OC")){
			pregunta = new PreguntaOrderedChoice(opciones);
		} else if (tipoPregunta.equalsIgnoreCase("GC")){
			pregunta = new PreguntaGroupChoice(opciones);
		}

		if (pregunta != null) pregunta.setearTexto(textoPregunta);
		return pregunta;
	}
}
