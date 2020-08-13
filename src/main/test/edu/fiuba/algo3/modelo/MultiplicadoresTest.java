package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoicePenalidad;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;

public class MultiplicadoresTest {

	/* PREGUNTA VERDADERO FALSO CON PENALIDAD */
	
	@Test
    public void test01JugadorActivaUnMultiplicadorPorDosYRespondeIncorrectamenteLaPreguntaYRecibeDosPuntosNegativos() {
        Opcion opcionVerdadero = new OpcionIncorrecta();
        Opcion opcionFalso = new OpcionCorrecta();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcionVerdadero);
        opciones.add(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");


        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        jugador.activarMultiplicadorPorDos();

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        assertEquals(-2,puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test02JugadorActivaUnMultiplicadorPorTresYRespondeIncorrectamenteLaPreguntaYRecibeTresPuntosNegativos() {
        Opcion opcionVerdadero = new OpcionIncorrecta();
        Opcion opcionFalso = new OpcionCorrecta();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcionVerdadero);
        opciones.add(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");


        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        jugador.activarMultiplicadorPorTres();

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        assertEquals(-3,puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorActivaDosVecesSuMultiplicadorContestandoDosPreguntasYSeVerificaQueSoloSeAplicoUnMultiplicador() {
        Opcion opcionVerdadero = new OpcionIncorrecta();
        Opcion opcionFalso = new OpcionCorrecta();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcionVerdadero);
        opciones.add(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad preguntaUno = new PreguntaVerdaderoFalsoPenalidad(opciones);
        PreguntaVerdaderoFalsoPenalidad preguntaDos = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");


        Iterator iteradorDeOpciones = preguntaUno.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        jugador.activarMultiplicadorPorTres();

        preguntaUno.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = preguntaUno.puntuarJugador(jugador);

        assertEquals(-3,puntajeDelJugador.obtenerPuntos());

        iteradorDeOpciones = preguntaDos.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        jugador.activarMultiplicadorPorTres();

        preguntaDos.agregarRespuestaDeJugador(jugador, respuestas);

        puntajeDelJugador = preguntaDos.puntuarJugador(jugador);

        assertEquals(-1,puntajeDelJugador.obtenerPuntos());
    }
    
    /* PREGUNTA MULTIPLE CHOICE CON PENALIDAD */
    
    @Test
    public void test04JugadorActivaUnMultiplicadorPorDosYRespondeIncorrectamenteLaPreguntaYRecibeCuatroPuntosNegativos() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion2);

        jugador.activarMultiplicadorPorDos();

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(-4, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test05JugadorActivaUnMultiplicadorPorDosYRespondeIncorrectamenteLaPreguntaYRecibeSeisPuntosNegativos() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoicePenalidad pregunta = new PreguntaMultipleChoicePenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion2);

        jugador.activarMultiplicadorPorTres();

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(-6, puntajeDelJugador.obtenerPuntos());
    }
}



