package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PreguntaVerdaderoFalsoTest {

	@Test
	public void testConstructorFuncionaCorrectamente() {
		PreguntaVerdaderoFalso preguntaPrueba = new PreguntaVerdaderoFalso(true);
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(true, preguntaPrueba.getRespuestaCorrecta());
	}
	
	@Test
	public void testRespondoCorrectamenteLaPreguntaGano1Punto() {
		PreguntaVerdaderoFalso preguntaPrueba = new PreguntaVerdaderoFalso(true);
		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(1);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(1, jugadorPrueba.getPuntos());
	}

}
