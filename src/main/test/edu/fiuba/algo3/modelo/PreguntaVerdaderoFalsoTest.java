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

}
