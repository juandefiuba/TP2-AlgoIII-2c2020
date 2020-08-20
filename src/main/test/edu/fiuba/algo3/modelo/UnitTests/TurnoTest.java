package edu.fiuba.algo3.modelo.UnitTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Turno;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TurnoTest {

	@Test
	public void test01TurnoAgregaOpcionElegidaDelJugadorActual() {
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(new Jugador());
		jugadores.add(new Jugador());

		Opcion opcion1 = new OpcionCorrecta();
		Opcion opcion2 = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<Opcion>();
		opciones.add(opcion1);
		opciones.add(opcion2);

		Pregunta preguntaMock = mock(PreguntaVerdaderoFalso.class);
		LinkedList<Pregunta> preguntas = new LinkedList<Pregunta>();
		preguntas.add(preguntaMock);
		Iterator iter = preguntas.iterator();

		Turno turno = new Turno();
		turno.iniciarJuegoCon(jugadores, iter);
		turno.agregarOpcionElegida(opcion1);
		verify(preguntaMock).agregarRespuestaDeJugador(any(Jugador.class), any(Opcion.class));
	}

	@Test
	public void test02TurnoObtenerPreguntaCorrecta() {
		LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
		jugadores.add(new Jugador());
		jugadores.add(new Jugador());

		Opcion opcion1 = new OpcionCorrecta();
		Opcion opcion2 = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<Opcion>();
		opciones.add(opcion1);
		opciones.add(opcion2);

		Pregunta preguntaMock = mock(PreguntaVerdaderoFalso.class);
		LinkedList<Pregunta> preguntas = new LinkedList<Pregunta>();
		preguntas.add(preguntaMock);
		Iterator iter = preguntas.iterator();

		Turno turno = new Turno();
		turno.iniciarJuegoCon(jugadores, iter);
		assertEquals(preguntaMock, turno.obtenerPregunta());
	}

}