package edu.fiuba.algo3.modelo.UnitTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaBase;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static edu.fiuba.algo3.modelo.Kahoot.Kahoot;
import static org.junit.jupiter.api.Assertions.*;

//String kahoot.verPreguntaActual(); string de pregunta
//String[] kahoot.verOpciones(); strings de opciones
//??? kahoot.verPuntajesDeJugador(); devolver puntajes como int para la vista
//kahoot.ponerExclusividad(); ???
//kahoot.ponerMultiplicador(); ???
//Agregar atributos de textos de preguntas y opciones

public class KahootTest {
	@Test
	public void test01KahootTerminaElJuegoCuandoNoHayMasPreguntas(){
		//TODO: Creación de preguntas y opciones como Factory desde un JSON
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();

		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);

		Pregunta pregunta = new PreguntaVerdaderoFalso(opciones);

		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		LinkedList<Opcion> respuestas = new LinkedList<>();
		respuestas.add(opcionVerdadero);

		//Clase Kahoot
		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		kahoot.iniciarJuego();

		while (kahoot.sigueElJuego()) {
			kahoot.agregarRespuestaDeJugadorActual(respuestas);
			kahoot.avanzarAProximoJugador();
			kahoot.agregarRespuestaDeJugadorActual(respuestas);
			kahoot.terminarTurno();
		}

		assertEquals(false, kahoot.sigueElJuego()); //:P
	}
	
	@Test
	public void test02AgregarOpcionElegida() {
		//Arrange
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalso(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();
		
		Kahoot.resetear();
		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		kahoot.agregarOpcionElegida(opcionVerdadero);
		kahoot.avanzarAProximoJugador();
		kahoot.agregarOpcionElegida(opcionFalso);
		kahoot.terminarTurno();
		assertEquals(1, jugadores.get(0).obtenerPuntos());
		
	}
	
	@Test
	public void testObtenerPreguntaActual() {
		Opcion opcionVerdadero = new OpcionCorrecta();
		opcionVerdadero.setearTexto("Mas bien");
		Opcion opcionFalso = new OpcionIncorrecta();
		opcionFalso.setearTexto("uf");
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);
		String texto = "Aprobamos?";
		pregunta.setearTexto(texto);
		Kahoot.resetear();
		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		kahoot.iniciarJuego();
		PreguntaBase preguntaPrueba = kahoot.obtenerPreguntaActual();
		Iterator iterador = preguntaPrueba.obtenerOpciones();
		Opcion opcion1 = (Opcion) iterador.next();
		Opcion opcion2 = (Opcion) iterador.next();
		assertEquals(texto, preguntaPrueba.obtenerTexto());
		assertEquals("Mas bien", opcion1.obtenerTexto());
		assertEquals("uf", opcion2.obtenerTexto());
	}
}
