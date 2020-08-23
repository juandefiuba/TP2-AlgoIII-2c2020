package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoHayJugadoresException;
import edu.fiuba.algo3.modelo.Excepciones.NoHayPreguntasException;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaBase;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalsoPenalidad;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class KahootTest {
	
	@Test
	public void test01CalificoyObtenerPuntosDevuelveCantidadCorrecta() throws IOException {
		//Arrange
		Kahoot.resetear();
		/*Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalso(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();*/

		Kahoot kahoot = Kahoot.Kahoot("./testLector1.json");
		//kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		Pregunta pregunta = kahoot.obtenerPreguntaActual();
		Iterator iterOpciones = pregunta.obtenerOpciones();
		kahoot.agregarOpcionElegida((Opcion) iterOpciones.next());
		kahoot.avanzarAProximoJugador();
		kahoot.agregarOpcionElegida((Opcion) iterOpciones.next());
		kahoot.terminarTurno();

		assertEquals(1, jugadores.get(0).obtenerPuntos());
		
	}

	@Test
	public void test02ObtenerTextoPreguntaYOpcionesActual() throws IOException {
		Kahoot.resetear();
		/*Opcion opcionVerdadero = new OpcionCorrecta();
		opcionVerdadero.setearTexto("Mas bien");
		Opcion opcionFalso = new OpcionIncorrecta();
		opcionFalso.setearTexto("uf");
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);
		String texto = "Aprobamos?";
		pregunta.setearTexto(texto);*/

		Kahoot kahoot = Kahoot.Kahoot("./testLector2.json");
		//kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		PreguntaBase preguntaPrueba = kahoot.obtenerPreguntaActual();
		Iterator iterador = preguntaPrueba.obtenerOpciones();
		Opcion opcion1 = (Opcion) iterador.next();
		Opcion opcion2 = (Opcion) iterador.next();

		assertEquals("¿Existe el 31 de febrero?", preguntaPrueba.obtenerTexto());
		assertEquals("Verdadero", opcion1.obtenerTexto());
		assertEquals("Falso", opcion2.obtenerTexto());
	}

	@Test
	public void test03UsarExclusividadDevuelvePuntosCorrectos() throws IOException {
		//Arrange
		Kahoot.resetear();
		/*Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalso(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();*/

		Kahoot kahoot = Kahoot.Kahoot("./testLector2.json");
		//kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		kahoot.activarExclusividad();
		PreguntaBase preguntaPrueba = kahoot.obtenerPreguntaActual();
		Iterator iterador = preguntaPrueba.obtenerOpciones();
		Opcion opcion1 = (Opcion) iterador.next();
		Opcion opcion2 = (Opcion) iterador.next();
		kahoot.agregarOpcionElegida(opcion2);
		kahoot.avanzarAProximoJugador();
		kahoot.agregarOpcionElegida(opcion1);
		kahoot.terminarTurno();

		assertEquals(2, jugadores.get(0).obtenerPuntos());
		assertEquals(0, jugadores.get(1).obtenerPuntos());
	}

	@Test
	public void test04UsarMultiplicadorPorDosDevuelvePuntosCorrectos() throws IOException {
		//Arrange
		Kahoot.resetear();
		/*Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();*/

		Kahoot kahoot = Kahoot.Kahoot("./testLector3.json");
		//kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		PreguntaBase preguntaPrueba = kahoot.obtenerPreguntaActual();
		Iterator iterador = preguntaPrueba.obtenerOpciones();
		Opcion opcion1 = (Opcion) iterador.next();
		Opcion opcion2 = (Opcion) iterador.next();
		kahoot.activarMultiplicadorPorDos();
		kahoot.agregarOpcionElegida(opcion1);
		kahoot.avanzarAProximoJugador();
		kahoot.activarMultiplicadorPorDos();
		kahoot.agregarOpcionElegida(opcion2);
		kahoot.terminarTurno();

		assertEquals(2, jugadores.get(0).obtenerPuntos());
		assertEquals(-2, jugadores.get(1).obtenerPuntos());
	}

	@Test
	public void test05UsarMultiplicadorPorTresDevuelvePuntosCorrectos() throws IOException {
		//Arrange
		Kahoot.resetear();
		/*Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();*/

		Kahoot kahoot = Kahoot.Kahoot("./testLector3.json");
		//kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		PreguntaBase preguntaPrueba = kahoot.obtenerPreguntaActual();
		Iterator iterador = preguntaPrueba.obtenerOpciones();
		Opcion opcion1 = (Opcion) iterador.next();
		Opcion opcion2 = (Opcion) iterador.next();
		kahoot.activarMultiplicadorPorTres();
		kahoot.agregarOpcionElegida(opcion1);
		kahoot.avanzarAProximoJugador();
		kahoot.activarMultiplicadorPorTres();
		kahoot.agregarOpcionElegida(opcion2);
		kahoot.terminarTurno();

		assertEquals(3, jugadores.get(0).obtenerPuntos());
		assertEquals(-3, jugadores.get(1).obtenerPuntos());
	}
}
