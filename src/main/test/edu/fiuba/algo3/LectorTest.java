package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;


public class LectorTest {
	@Test
	public void test01LectorLaListaDePreguntasObtenidasEsDeTamanioCorrecto() throws IOException {
		String ruta = "./testLector1.json";
		Lector lector = new Lector(ruta);
		LinkedList<Pregunta> preguntas = lector.obtenerPreguntas();
		assertEquals(1, preguntas.size());
	}

	@Test
	public void test02LectorObtengoUnaPreguntaVoFClasicoConTextoEsperado() throws IOException {
		String ruta = "./testLector1.json";
		Lector lector = new Lector(ruta);
		LinkedList<Pregunta> preguntas = lector.obtenerPreguntas();
		Iterator iterador = preguntas.iterator();
		PreguntaVerdaderoFalso pregunta = (PreguntaVerdaderoFalso) iterador.next();
		assertEquals("¿Otelo fue escrito por Shakespeare?", pregunta.obtenerTexto());
	}

	@Test
	public void test03LectorObtengoTextosDeOpcionesEsperadosEnPreguntaVoF() throws IOException {
		String ruta = "./testLector1.json";
		Lector lector = new Lector(ruta);
		LinkedList<Pregunta> preguntas = lector.obtenerPreguntas();
		Iterator iterPreguntas = preguntas.iterator();
		PreguntaVerdaderoFalso pregunta = (PreguntaVerdaderoFalso) iterPreguntas.next();
		Iterator iterOpciones = pregunta.obtenerOpciones();
		Opcion opcion1 = (Opcion) iterOpciones.next();
		Opcion opcion2 = (Opcion) iterOpciones.next();
		assertEquals("Verdadero", opcion1.obtenerTexto());
		assertEquals("Falso", opcion2.obtenerTexto());
	}
}