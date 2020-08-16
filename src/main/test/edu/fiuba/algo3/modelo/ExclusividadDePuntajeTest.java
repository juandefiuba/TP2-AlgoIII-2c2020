package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;

public class ExclusividadDePuntajeTest {

	/* PREGUNTA VERDADERO FALSO */
	
	@Test
	public void test01UnJugadorActivaExclusividadDePuntajeYGanaElDobleDePuntosPorqueJugador2RespondeMal() {
		Opcion opcionVerdadero = new OpcionIncorrecta();
		Opcion opcionFalso = new OpcionCorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador();
		Jugador jugador2 = new Jugador();

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		LinkedList<Opcion> respuestas = new LinkedList<>();
		LinkedList<Opcion> respuestas2 = new LinkedList<>();

		respuestas.add(opcionFalso);
		respuestas2.add(opcionVerdadero);

		jugador.activarExclusividad();

		pregunta.agregarRespuestaDeJugador(jugador, respuestas);
		pregunta.agregarRespuestaDeJugador(jugador2, respuestas2);

		pregunta.puntuarJugadores(jugador, jugador2);

		//Act
		//Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		assertEquals(2,jugador.obtenerPuntos());
	}

	@Test
	public void test02DosJugadoresActivanExclusividadDePuntajeYGanaElCuadrupleDePuntosPorqueJugador2RespondeMal() {
		Opcion opcionVerdadero = new OpcionIncorrecta();
		Opcion opcionFalso = new OpcionCorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador();
		Jugador jugador2 = new Jugador();

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		LinkedList<Opcion> respuestas = new LinkedList<>();
		LinkedList<Opcion> respuestas2 = new LinkedList<>();

		respuestas.add(opcionFalso);
		respuestas2.add(opcionVerdadero);

		jugador.activarExclusividad();
		jugador2.activarExclusividad();

		pregunta.agregarRespuestaDeJugador(jugador, respuestas);
		pregunta.agregarRespuestaDeJugador(jugador2, respuestas2);

		pregunta.puntuarJugadores(jugador, jugador2);

		//Act
		//Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		assertEquals(4,jugador.obtenerPuntos());
	}

	@Test
	public void test03DosJugadoresActivanExclusividadDePuntajeYRespondenAmbosBienEntoncesNoGananPuntos(){
		Opcion opcionVerdadero = new OpcionIncorrecta();
		Opcion opcionFalso = new OpcionCorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador();
		Jugador jugador2 = new Jugador();

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		LinkedList<Opcion> respuestas = new LinkedList<>();
		LinkedList<Opcion> respuestas2 = new LinkedList<>();

		respuestas.add(opcionFalso);
		respuestas2.add(opcionFalso);

		jugador.activarExclusividad();
		jugador2.activarExclusividad();

		pregunta.agregarRespuestaDeJugador(jugador, respuestas);
		pregunta.agregarRespuestaDeJugador(jugador2, respuestas2);

		pregunta.puntuarJugadores(jugador, jugador2);

		//Act
		//Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		assertEquals(0,jugador.obtenerPuntos());
	}
}
