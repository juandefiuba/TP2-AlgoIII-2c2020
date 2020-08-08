package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class PreguntaVerdaderoFalsoTest {

	/*@Test
	public void test01CrearPreguntaVerdaderoFalso(){
		Opcion opcionVerdadero = new Opcion(new Correcto());
		Opcion opcionFalso = new Opcion(new Incorrecto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		assertEquals(opcionVerdadero, iteradorDeOpciones.next());
	}*/

	@Test
	public void test02JugadorRespondeCorrectamenteSumaUnPunto() {
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

		opcionVerdadero.agregarJugadorQueLaEligio(jugador);

		//Act
		Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		//Assert
		assertEquals(1, puntajeDelJugador.obtenerPuntos());
	}

	@Test
	public void test03JugadorRespondeMalNoRecibePunto() {
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

		opcionVerdadero.agregarJugadorQueLaEligio(jugador);

		//Act
		Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		//Assert
		assertEquals(0, puntajeDelJugador.obtenerPuntos());
	}

	@Test
	public void test04JugadorRespondeCorrectamenteSumaUnPunto() {
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

		opcionFalso.agregarJugadorQueLaEligio(jugador);

		//Act
		Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		//Assert
		assertEquals(1, puntajeDelJugador.obtenerPuntos());
	}

	@Test
	public void test05JugadorRespondeMalNoRecibePunto() {
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

		//jugador.elegirOpcion(opcionVerdadero);
		//jugador.activarMultiplicador();
		opcionFalso.agregarJugadorQueLaEligio(jugador);

		//Act
		Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

		assertEquals(1,puntajeDelJugador.obtenerPuntos());
	}
}
