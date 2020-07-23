package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class VerdaderoFalsoTest {

	@Test
	public void testPreguntaVoFInicializaCorrectamente() {
		String problema = "Cree usted que es momento de entrar en panico?";
		Respuesta respuestaPrueba = new RespuestaVerdaderoFalso("Verdadero");
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Verdadero");
		opciones.add("Falsoooo");
		
		Pregunta preguntaPrueba = new Pregunta(problema, respuestaPrueba, opciones);
		
		assertEquals(problema, preguntaPrueba.getProblema());
		assertTrue(preguntaPrueba.esCorrecto(respuestaPrueba));
		assertEquals(opciones, preguntaPrueba.getOpciones());
	}
	
	@Test
	public void testSeRespondeCorrectamenteYSeConsigueElPuntaje() {
		String problema = "Cree usted que es momento de entrar en panico?";
		Respuesta respuestaPrueba = new RespuestaVerdaderoFalso("Verdadero");
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Verdadero");
		opciones.add("Falso");
		
		Pregunta preguntaPrueba = new Pregunta(problema, respuestaPrueba, opciones);
		assertEquals(1, preguntaPrueba.calificarRespuesta(respuestaPrueba));
	}

}
