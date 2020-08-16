package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeValido;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class PreguntaVerdaderoFalsoTest {

	@Test
	public void test01JugadorRespondeCorrectamenteSumaUnPunto() {
		//Arrange
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		LinkedList<Opcion> respuestas = new LinkedList<>();

		respuestas.add(opcionVerdadero);
		pregunta.agregarRespuestaDeJugador(jugador, respuestas);

		//Act
		Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		//Assert
		assertEquals(1, puntajeDelJugador.obtenerPuntos());
	}

	@Test
	public void test02JugadorRespondeMalNoRecibePunto() {
		Opcion opcionVerdadero = new OpcionIncorrecta();
		Opcion opcionFalso = new OpcionCorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();


		LinkedList<Opcion> respuestas = new LinkedList<>();

		respuestas.add(opcionVerdadero);
		pregunta.agregarRespuestaDeJugador(jugador, respuestas);

		//Act
		Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		//Assert
		assertEquals(0, puntajeDelJugador.obtenerPuntos());
	}

	@Test
	public void test03JugadorRespondeCorrectamenteSumaUnPunto() {
		//Arrange se invierten los estados, ahora falso es correcto
		Opcion opcionVerdadero = new OpcionIncorrecta();
		Opcion opcionFalso = new OpcionCorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		LinkedList<Opcion> respuestas = new LinkedList<>();

		respuestas.add(opcionFalso);
		pregunta.agregarRespuestaDeJugador(jugador, respuestas);

		//Act
		Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		//Assert
		assertEquals(1, puntajeDelJugador.obtenerPuntos());
	}

	@Test
	public void test04JugadorRespondeMalNoRecibePunto() {
		Opcion opcionVerdadero = new OpcionIncorrecta();
		Opcion opcionFalso = new OpcionCorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		LinkedList<Opcion> respuestas = new LinkedList<>();

		respuestas.add(opcionFalso);
		pregunta.agregarRespuestaDeJugador(jugador, respuestas);

		//Act
		Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		assertEquals(1,puntajeDelJugador.obtenerPuntos());
	}
	

}
