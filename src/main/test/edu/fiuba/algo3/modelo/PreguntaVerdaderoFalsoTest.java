package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PreguntaVerdaderoFalsoTest {

	@Test
	public void testConstructorVerdaderaFuncionaCorrectamente() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(true, preguntaPrueba.getRespuestaCorrecta());
	}
	@Test
	public void testConstructorFalsaFuncionaCorrectamente2() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaFalsa();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(false, preguntaPrueba.getRespuestaCorrecta());
	}
	
	@Test
	public void testRespondoCorrectamenteLaPreguntaGano1Punto() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(1);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(1, jugadorPrueba.getPuntos());
	}

	@Test
	public void testRespondoCorrectamenteLaPreguntaGano0Punto() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(0);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(0, jugadorPrueba.getPuntos());
	}
}
