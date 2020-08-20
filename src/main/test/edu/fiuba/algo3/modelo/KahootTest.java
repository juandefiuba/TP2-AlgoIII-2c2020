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

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class KahootTest {
	@Test
	public void test01SeLevantaLaExcepcionCorrectaCuandoNoHayPreguntas(){
		Kahoot.resetear();
		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");

		assertThrows(NoHayPreguntasException.class, kahoot::iniciarJuego);
	}

	@Test
	public void test02SeLevantaLaExcepcionCorrectaCuandoNoHayJugadores(){
		//Arrange
		Kahoot.resetear();
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalso(opciones);

		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarPregunta(pregunta);

		assertThrows(NoHayJugadoresException.class, kahoot::iniciarJuego);
	}
	
	@Test
	public void test03CalificoyObtenerPuntosDevuelveCantidadCorrecta() {
		//Arrange
		Kahoot.resetear();
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalso(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

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
	public void test04ObtenerTextoPreguntaYOpcionesActual() {
		Kahoot.resetear();
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

	@Test
	public void test05UsarExclusividadDevuelvePuntosCorrectos() {
		//Arrange
		Kahoot.resetear();
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalso(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		kahoot.activarExclusividad();
		kahoot.agregarOpcionElegida(opcionVerdadero);
		kahoot.avanzarAProximoJugador();
		kahoot.agregarOpcionElegida(opcionFalso);
		kahoot.terminarTurno();

		assertEquals(2, jugadores.get(0).obtenerPuntos());
		
	}
	
	@Test
	public void test06UsarMultiplicadorPorDosDevuelvePuntosCorrectos() {
		//Arrange
		Kahoot.resetear();
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		kahoot.activarMultiplicadorPorDos();
		kahoot.agregarOpcionElegida(opcionVerdadero);
		kahoot.avanzarAProximoJugador();
		kahoot.activarMultiplicadorPorDos();
		kahoot.agregarOpcionElegida(opcionFalso);
		kahoot.terminarTurno();

		assertEquals(2, jugadores.get(0).obtenerPuntos());
		assertEquals(-2, jugadores.get(1).obtenerPuntos());
	}
	
	@Test
	public void test07UsarMultiplicadorPorTresDevuelvePuntosCorrectos() {
		//Arrange
		Kahoot.resetear();
		Opcion opcionVerdadero = new OpcionCorrecta();
		Opcion opcionFalso = new OpcionIncorrecta();
		LinkedList<Opcion> opciones = new LinkedList<>();
		opciones.add(opcionVerdadero);
		opciones.add(opcionFalso);
		Pregunta pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);
		Iterator iteradorDeOpciones = pregunta.obtenerOpciones();
		opcionVerdadero = (Opcion) iteradorDeOpciones.next();
		opcionFalso = (Opcion) iteradorDeOpciones.next();

		Kahoot kahoot = Kahoot.Kahoot();
		kahoot.agregarPregunta(pregunta);
		kahoot.agregarJugador("Mica");
		kahoot.agregarJugador("Juancito");
		LinkedList<Jugador> jugadores = kahoot.obtenerJugadores();
		kahoot.iniciarJuego();
		kahoot.activarMultiplicadorPorTres();
		kahoot.agregarOpcionElegida(opcionVerdadero);
		kahoot.avanzarAProximoJugador();
		kahoot.activarMultiplicadorPorTres();
		kahoot.agregarOpcionElegida(opcionFalso);
		kahoot.terminarTurno();

		assertEquals(3, jugadores.get(0).obtenerPuntos());
		assertEquals(-3, jugadores.get(1).obtenerPuntos());
	}
	
}
