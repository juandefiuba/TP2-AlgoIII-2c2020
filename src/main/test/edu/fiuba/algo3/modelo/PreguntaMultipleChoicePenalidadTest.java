package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoicePenalidad;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoicePenalidadTest {

    @Test
    public void test01JugadorRespondeOpciones1Correcta1IncorrectaDeMCPenalidadYGana0Puntos() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionCorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionIncorrecta();
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

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test02JugadorRespondeOpciones1Correcta2IncorrectaDeMCPenalidadYPierde1Punto() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionCorrecta();
        Opcion opcion3 = new OpcionIncorrecta();
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
        respuestas.add(opcion3);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(-1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorResponde1OpcionIncorrectaDeMCPenalidadYPierde1Punto() {
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

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);


        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(-1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test04JugadorResponde2OpcionesIncorrectasDeMCPenalidadYPierde2Puntos() {
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

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);


        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(-2, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test05JugadorResponde2OpcionesCorrectasDeMCPenalidadYGana2Puntos() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionCorrecta();
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

        respuestas.add(opcion2);
        respuestas.add(opcion3);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(2, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test06JugadorActivaUnMultiplicadorPorDosYRespondeIncorrectamenteLaPreguntaYRecibeCuatroPuntosNegativos() {
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
    public void test07JugadorActivaUnMultiplicadorPorDosYRespondeIncorrectamenteLaPreguntaYRecibeSeisPuntosNegativos() {
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
