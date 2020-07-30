package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalsoPenalidad;

public class PreguntaVerdaderoFalsoPenalidadTest {

	@Test
	public void testConstructorPreguntaVerdaderaPenalidad() {
		PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.newPreguntaVerdadera();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(true, preguntaPrueba.esPreguntaVerdadera());
	}
	
	@Test
	public void testConstructorPreguntaFalsaPenlidad() {
		PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.newPreguntaFalsa();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(false, preguntaPrueba.esPreguntaVerdadera());
	}
	
	@Test
	public void testRespondoCorrectamenteLaPreguntaVerdaderaGano1Punto() {
		PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.newPreguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("Armando Barredas");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionElegida(1);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(1, jugadorPrueba.getPuntos());
	}
	
	@Test
	public void testRespondoCorrectamenteLaPreguntaFalsaGano1Punto() {
		PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.newPreguntaFalsa();
		Jugador jugadorPrueba = new Jugador("Aquiles Caigo");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionElegida(2);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(1, jugadorPrueba.getPuntos());
	}
	
	@Test
	public void testRespondoIncorrectamenteLaPreguntaVerdaderaPierde1Punto() {
		PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.newPreguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("Jhonny Codeo");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionElegida(2);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(-1, jugadorPrueba.getPuntos());
	}
	
	@Test
	public void testRespondoIncorrectamenteLaPreguntaFalsaPierde1Puntos() {
		PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.newPreguntaFalsa();
		Jugador jugadorPrueba = new Jugador("Jamal");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionElegida(1);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(-1, jugadorPrueba.getPuntos());
	}
	
	

}
