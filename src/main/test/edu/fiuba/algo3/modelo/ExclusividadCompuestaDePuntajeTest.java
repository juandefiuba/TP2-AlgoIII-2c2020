package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;

public class ExclusividadCompuestaDePuntajeTest {

	@Test
	public void test01UnJugadorActivaExclusividadDePuntajeYGanaElDobleDePuntosPorqueJugador2RespondeMal() {
		//Arrange
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

		assertEquals(2,jugador.obtenerPuntos());
	}

	@Test
	public void test02DosJugadoresActivanExclusividadDePuntajeYGanaElCuadrupleDePuntosPorqueJugador2RespondeMal() {
		//Arrange
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
		//Act
		jugador.activarExclusividad();
		jugador2.activarExclusividad();

		pregunta.agregarRespuestaDeJugador(jugador, respuestas);
		pregunta.agregarRespuestaDeJugador(jugador2, respuestas2);

		pregunta.puntuarJugadores(jugador, jugador2);

		assertEquals(4,jugador.obtenerPuntos());
	}

	@Test
	public void test03DosJugadoresActivanExclusividadDePuntajeYRespondenAmbosBienEntoncesNoGananPuntos(){
		//Arrange
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

		//Act
		jugador.activarExclusividad();
		jugador2.activarExclusividad();

		pregunta.agregarRespuestaDeJugador(jugador, respuestas);
		pregunta.agregarRespuestaDeJugador(jugador2, respuestas2);

		pregunta.puntuarJugadores(jugador, jugador2);

		assertEquals(0,jugador.obtenerPuntos());
	}
}
