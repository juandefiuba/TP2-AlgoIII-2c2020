package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Verdadero;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Falso;
import org.junit.jupiter.api.Test;

public class PreguntaVerdaderoFalsoTest {

	@Test
	public void test01ConstructorVerdaderaFuncionaCorrectamente() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(Verdadero.class, (preguntaPrueba.getRespuestaCorrecta()).getClass());
	}

	@Test
	public void test02ConstructorFalsaFuncionaCorrectamente() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaFalsa();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(Falso.class, (preguntaPrueba.getRespuestaCorrecta()).getClass());
	}

	@Test
	public void test03RespondeCorrectamenteLaPreguntaGana1Punto() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(1);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(1, jugadorPrueba.getPuntos());
	}

	@Test
	public void test04RespondeIncorrectamenteLaPreguntaNoRecibePunto() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(0);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(0, jugadorPrueba.getPuntos());
	}

	@Test
	public void test05RespondeCorrectamente2PreguntasVerdaderasGana2Punto() {
		PreguntaVerdaderoFalso preguntaPrueba1 = PreguntaVerdaderoFalso.preguntaVerdadera();
		PreguntaVerdaderoFalso preguntaPrueba2 = PreguntaVerdaderoFalso.preguntaVerdadera();

		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba1.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(1);
		preguntaPrueba1.calificarRespuesta(respuestaPrueba);
		preguntaPrueba2.calificarRespuesta(respuestaPrueba);
		assertEquals(2, jugadorPrueba.getPuntos());
	}

	@Test
	public void test06RespondeCorrectamente1De2PreguntasGana1Punto() {
		PreguntaVerdaderoFalso preguntaPrueba1 = PreguntaVerdaderoFalso.preguntaVerdadera();
		PreguntaVerdaderoFalso preguntaPrueba2 = PreguntaVerdaderoFalso.preguntaFalsa();

		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba1.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(1);
		preguntaPrueba1.calificarRespuesta(respuestaPrueba);  //responde Bien
		preguntaPrueba2.calificarRespuesta(respuestaPrueba);   //responde Mal
		assertEquals(1, jugadorPrueba.getPuntos());
	}

	@Test
	public void test07RespondeIncorrectamente2De2PreguntasNoGanaPuntos() {
		PreguntaVerdaderoFalso preguntaPrueba1 = PreguntaVerdaderoFalso.preguntaVerdadera();
		PreguntaVerdaderoFalso preguntaPrueba2 = PreguntaVerdaderoFalso.preguntaFalsa();

		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba1.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(0);
		preguntaPrueba1.calificarRespuesta(respuestaPrueba);  //responde Mal

		respuestaPrueba = preguntaPrueba2.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(1);
		preguntaPrueba2.calificarRespuesta(respuestaPrueba);   //responde Mal
		assertEquals(0, jugadorPrueba.getPuntos());
	}

}