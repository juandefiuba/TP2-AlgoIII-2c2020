package edu.fiuba.algo3.modelo2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo2.EstadosDeOpcion.Correcto;
import edu.fiuba.algo3.modelo2.EstadosDeOpcion.Incorrecto;
import edu.fiuba.algo3.modelo2.Preguntas.PreguntaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

//import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;

public class PreguntaVerdaderoFalsoTest {

	@Test
	public void test01CrearPreguntaVerdaderoFalso(){
		Opcion opcionVerdadero = new Opcion(new Correcto());
		Opcion opcionFalso = new Opcion(new Incorrecto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		assertEquals(opcionVerdadero, iteradorDeOpciones.next());
	}

	@Test
	public void test02JugadorRespondeCorrectamenteSumaUnPunto() {
		//Arrange
		Opcion opcionVerdadero = new Opcion(new Correcto());
		Opcion opcionFalso = new Opcion(new Incorrecto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		pregunta.registrarNuevoJugador(jugador);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		//Act
		opcionVerdadero.agregarJugadorQueLaEligio(jugador);
		pregunta.puntuarJugadores();

		//Assert
		assertEquals(1,jugador.obtenerPuntos());
	}

	@Test
	public void test03JugadorRespondeMalNoRecibePunto() {
		Opcion opcionVerdadero = new Opcion(new Incorrecto());
		Opcion opcionFalso = new Opcion(new Correcto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		pregunta.registrarNuevoJugador(jugador);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		//jugador.elegirOpcion(opcionVerdadero);
		//jugador.activarMultiplicador();
		opcionVerdadero.agregarJugadorQueLaEligio(jugador);

		pregunta.puntuarJugadores();

		assertEquals(0,jugador.obtenerPuntos());
	}
	@Test
	public void test04JugadorRespondeCorrectamenteSumaUnPunto() {
		//Arrange se invierten los estados, ahora falso es correcto
		Opcion opcionVerdadero = new Opcion(new Incorrecto());
		Opcion opcionFalso = new Opcion(new Correcto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		pregunta.registrarNuevoJugador(jugador);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		//Act
		opcionFalso.agregarJugadorQueLaEligio(jugador);
		pregunta.puntuarJugadores();

		//Assert
		assertEquals(1,jugador.obtenerPuntos());
	}

	@Test
	public void test05JugadorRespondeMalNoRecibePunto() {
		Opcion opcionVerdadero = new Opcion(new Incorrecto());
		Opcion opcionFalso = new Opcion(new Correcto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		pregunta.registrarNuevoJugador(jugador);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		//jugador.elegirOpcion(opcionVerdadero);
		//jugador.activarMultiplicador();
		opcionFalso.agregarJugadorQueLaEligio(jugador);

		pregunta.puntuarJugadores();

		assertEquals(1,jugador.obtenerPuntos());
	}
}
