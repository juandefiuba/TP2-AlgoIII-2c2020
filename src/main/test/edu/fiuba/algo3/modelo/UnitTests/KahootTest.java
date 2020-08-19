package edu.fiuba.algo3.modelo.UnitTests;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static edu.fiuba.algo3.modelo.Kahoot.Kahoot;
import static org.junit.jupiter.api.Assertions.*;

public class KahootTest {
	@Test
	public void test01KahootTerminaElJuegoCuandoNoHayMasPreguntas(){
		//TODO: Creación de preguntas y opciones como Factory desde un JSON
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		Pregunta pregunta = new PreguntaVerdaderoFalso(opciones);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		LinkedList<Opcion> respuestas = new LinkedList<>();
		respuestas.add(opcionVerdadero);

		//Clase Kahoot
		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		kahoot.iniciarJuego();

		while (kahoot.sigueElJuego()) {
			kahoot.agregarRespuestaDeJugadorActual(respuestas);
			kahoot.avanzarAProximoJugador();
			kahoot.agregarRespuestaDeJugadorActual(respuestas);
			kahoot.terminarTurno();
		}

		assertEquals(false, kahoot.sigueElJuego()); //:P
	}
}