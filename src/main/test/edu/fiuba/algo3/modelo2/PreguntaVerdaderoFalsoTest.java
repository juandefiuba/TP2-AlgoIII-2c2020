package edu.fiuba.algo3.modelo2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
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

	public void test02JugadorRespondePreguntaCorrectamente(){
		Opcion opcionVerdadero = new Opcion(new Incorrecto());
		Opcion opcionFalso = new Opcion(new Correcto());

		ColeccionDeOpciones opciones = new ColeccionDeOpciones();
		opciones.agregarOpcion(opcionVerdadero);
		opciones.agregarOpcion(opcionFalso);

		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

		Jugador jugador = new Jugador();

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
