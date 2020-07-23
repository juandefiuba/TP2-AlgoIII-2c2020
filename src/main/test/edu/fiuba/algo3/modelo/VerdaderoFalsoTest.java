package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class VerdaderoFalsoTest {

	@Test
	public void testPreguntaVoFInicializaCorrectamente() {
		String problema = "Cree usted que es momento de entrar en panico?";
		RespuestaVerdaderoFalso respuestaPrueba = new RespuestaVerdaderoFalso("Verdadero", new Jugador("pepe"));
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Verdadero");
		opciones.add("Falso");
		
		Pregunta preguntaPrueba = new Pregunta(problema, respuestaPrueba, opciones);
		
		assertEquals(problema, preguntaPrueba.getProblema());
		assertEquals(1,preguntaPrueba.calificarRespuesta(respuestaPrueba));
		assertEquals(opciones, preguntaPrueba.getOpciones());
	}
	
	@Test
	public void testInicializarPreguntaVoFConMetodoDeClaseFunciona() {
		String problema = "El cielo es rosa?";
		RespuestaVerdaderoFalso respuestaPrueba = new RespuestaVerdaderoFalso("Falso", new Jugador("pepe"));
		Pregunta preguntaPrueba = Pregunta.crearPreguntaVerdaderoFalso(problema, respuestaPrueba);
		assertEquals(problema, preguntaPrueba.getProblema());
		assertEquals(1, preguntaPrueba.calificarRespuesta(respuestaPrueba));
	}
	
	@Test
	public void testSeRespondeCorrectamenteYSeConsigueElPuntaje() {
		String problema = "Cree usted que es momento de entrar en panico?";
		RespuestaVerdaderoFalso respuestaPrueba = new RespuestaVerdaderoFalso("Verdadero", new Jugador("pepe"));
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Verdadero");
		opciones.add("Falso");
		
		Pregunta preguntaPrueba = new Pregunta(problema, respuestaPrueba, opciones);
		assertEquals(1, preguntaPrueba.calificarRespuesta(respuestaPrueba));
	}
	
	@Test
	public void testSeRespondeErroneamenteYNoSeConsiguePuntaje() {
		String problema = "Cree usted que es momento de entrar en panico?";
		RespuestaVerdaderoFalso respuestaPrueba = new RespuestaVerdaderoFalso("Verdadero", new Jugador("pepe"));
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Verdadero");
		opciones.add("Falso");
		RespuestaVerdaderoFalso respuestaErronea = new RespuestaVerdaderoFalso("meh", new Jugador("pepe"));
		
		Pregunta preguntaPrueba = new Pregunta(problema, respuestaPrueba, opciones);
		assertEquals(0, preguntaPrueba.calificarRespuesta(respuestaErronea));
	}

}
