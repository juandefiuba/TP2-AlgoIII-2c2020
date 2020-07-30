package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PreguntaVerdaderoFalsoTest {

	@Test
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
	}
	

}
