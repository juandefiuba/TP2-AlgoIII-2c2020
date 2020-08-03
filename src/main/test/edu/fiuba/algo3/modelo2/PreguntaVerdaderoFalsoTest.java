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
		Opcion opcionVerdadero = new Opcion(new Incorrecto());
		Opcion opcionFalso = new Opcion(new Correcto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		assertEquals(opcionVerdadero, iteradorDeOpciones.next());
	}

	@Test
	public void test02JugadorRespondePreguntaCorrectamente() {
		//Arrange
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
	public void test03JugadorRespondeMalNoRecibePunto() {
		Opcion opcionVerdadero = new Opcion(new Incorrecto());
		Opcion opcionFalso = new Opcion(new Correcto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador("Carlito");

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		//jugador.elegirOpcion(opcionVerdadero);
		//jugador.activarMultiplicador();
		opcionVerdadero.agregarJugadorQueLaEligio(jugador);

		pregunta.puntuarJugadores();

		assertEquals(0,jugador.obtenerPuntos());
	}
	/*@Test
	public void testConstructorPreguntaVerdadera() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.newPreguntaVerdadera();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(true, preguntaPrueba.esPreguntaVerdadera());
	}
	
	@Test
	public void testConstructorPreguntaFalsa() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.newPreguntaFalsa();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(false, preguntaPrueba.esPreguntaVerdadera());
	}
	
	@Test
	public void testRespondoCorrectamenteLaPreguntaVerdaderaGano1Punto() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.newPreguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("Armando Barredas");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionElegida(1);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(1, jugadorPrueba.getPuntos());
	}
	
	@Test
	public void testRespondoCorrectamenteLaPreguntaFalsaGano1Punto() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.newPreguntaFalsa();
		Jugador jugadorPrueba = new Jugador("Aquiles Caigo");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionElegida(2);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(1, jugadorPrueba.getPuntos());
	}
	
	@Test
	public void testRespondoIncorrectamenteLaPreguntaVerdaderaNoGano() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.newPreguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("Jhonny Codeo");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionElegida(2);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(0, jugadorPrueba.getPuntos());
	}
	
	@Test
	public void testRespondoIncorrectamenteLaPreguntaFalsaNoGano() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.newPreguntaFalsa();
		Jugador jugadorPrueba = new Jugador("Jamal");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionElegida(1);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(0, jugadorPrueba.getPuntos());
	}*/
	

}
