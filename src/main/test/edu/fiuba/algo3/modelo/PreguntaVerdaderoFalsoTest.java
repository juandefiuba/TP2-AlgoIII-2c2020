package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Correcto;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Incorrecto;
import org.junit.jupiter.api.Test;

public class PreguntaVerdaderoFalsoTest {
	//SE USAN LAS POSICIONES 1 PARA VERDADERA Y 2 PARA FALSO
	int posicionVerdadera = 1;
	int posicionFalsa = 2;

	@Test
	public void test01ConstructorVerdaderaFuncionaCorrectamente() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(Correcto.class, (preguntaPrueba.getRespuestaCorrecta()).getClass());
	}


	@Test
	public void test02ConstructorFalsaFuncionaCorrectamente() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaFalsa();
		assertEquals(2, preguntaPrueba.getCantidadOpciones());
		assertEquals(Incorrecto.class, (preguntaPrueba.getRespuestaCorrecta()).getClass());
	}


	@Test
	public void test03RespondeCorrectamenteLaPreguntaGana1Punto() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(posicionVerdadera);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(1, jugadorPrueba.getPuntos());
	}

	@Test
	public void test04RespondeIncorrectamenteLaPreguntaNoRecibePunto() {
		PreguntaVerdaderoFalso preguntaPrueba = PreguntaVerdaderoFalso.preguntaVerdadera();
		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(posicionFalsa);
		preguntaPrueba.calificarRespuesta(respuestaPrueba);
		assertEquals(0, jugadorPrueba.getPuntos());
	}

	@Test
	public void test05RespondeCorrectamente2PreguntasVerdaderasGana2Punto() {
		PreguntaVerdaderoFalso preguntaPrueba1 = PreguntaVerdaderoFalso.preguntaVerdadera();
		PreguntaVerdaderoFalso preguntaPrueba2 = PreguntaVerdaderoFalso.preguntaVerdadera();

		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba1.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(posicionVerdadera);
		preguntaPrueba1.calificarRespuesta(respuestaPrueba);
		preguntaPrueba2.calificarRespuesta(respuestaPrueba);
		assertEquals(2, jugadorPrueba.getPuntos());
	}

	@Test
	public void test06RespondeCorrectamente1De2PreguntasGana1Punto() {
		PreguntaVerdaderoFalso preguntaPrueba1 = PreguntaVerdaderoFalso.preguntaVerdadera();
		PreguntaVerdaderoFalso preguntaPrueba2 = PreguntaVerdaderoFalso.preguntaFalsa();

		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba1 = preguntaPrueba1.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba1.agregarOpcionCorrecta(posicionVerdadera);
		preguntaPrueba1.calificarRespuesta(respuestaPrueba1); //responde Bien

		Respuesta respuestaPrueba2 = preguntaPrueba2.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba2.agregarOpcionCorrecta(posicionVerdadera);
		preguntaPrueba2.calificarRespuesta(respuestaPrueba2);   //responde Mal

		assertEquals(1, jugadorPrueba.getPuntos());
	}

	@Test
	public void test07RespondeIncorrectamente2De2PreguntasNoGanaPuntos() {
		PreguntaVerdaderoFalso preguntaPrueba1 = PreguntaVerdaderoFalso.preguntaVerdadera();
		PreguntaVerdaderoFalso preguntaPrueba2 = PreguntaVerdaderoFalso.preguntaFalsa();

		Jugador jugadorPrueba = new Jugador("NN");
		Respuesta respuestaPrueba = preguntaPrueba1.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(posicionFalsa);
		preguntaPrueba1.calificarRespuesta(respuestaPrueba);  //responde Mal

		respuestaPrueba = preguntaPrueba2.getModeloDeRespuesta(jugadorPrueba);
		respuestaPrueba.agregarOpcionCorrecta(posicionVerdadera);
		preguntaPrueba2.calificarRespuesta(respuestaPrueba);   //responde Mal
		assertEquals(0, jugadorPrueba.getPuntos());
	}

}