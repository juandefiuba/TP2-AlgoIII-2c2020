package edu.fiuba.algo3.modelo.UnitTests;

import edu.fiuba.algo3.modelo.Excepciones.NoHayPreguntasException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Turno;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class KahootTest {

	@Test
	public void test01KahootIniciarJuegoSinPreguntasNiJugadoresDevuelveLaExcepcionCorrecta() {
		Kahoot.resetear();
		Kahoot kahoot = Kahoot.Kahoot();
		assertThrows(NoHayPreguntasException.class, kahoot::iniciarJuego);
	}

	@Test
	public void test02KahootAgregoUnJugadorYLuegoObtengoLaMismaCantidad() {
		Kahoot.resetear();
		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarJugador("Mica");
		assertEquals(1, kahoot.obtenerJugadores().size());
	}

	@Test
	public void agregarRespuestaDeJugadorActual() {
	}

	@Test
	public void agregarOpcionElegida() {
	}

	@Test
	public void agregarPregunta() {
	}

	@Test
	public void terminarTurno() {
	}

	@Test
	public void sigueElJuego() {
	}

	@Test
	public void obtenerPreguntaActual() {
	}

	@Test
	public void obtenerJugadorActual() {
	}

	@Test
	public void activarMultiplicadorPorDos() {
	}

	@Test
	public void activarMultiplicadorPorTres() {
	}

	@Test
	public void activarExclusividad() {
	}
}