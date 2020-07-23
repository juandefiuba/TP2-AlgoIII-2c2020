package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RespuestaVerdaderoFalsoTest {

	@Test
	public void testComparoConUnaRespuestaIgualEntoncesDevuelve1() {
		RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso("Verdadero");
		assertEquals(1, respuesta.comparar(respuesta));
	}

}
