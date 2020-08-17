package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrdenada;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaOrderedChoiceTest {
    @Test
    public void test01JugadorRespondePreguntaEnOrdenCorrectoRecibePunto() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionOrdenada();
        Opcion opcion2 = new OpcionOrdenada();
        Opcion opcion3 = new OpcionOrdenada();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice(opciones);

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion2);
        respuestas.add(opcion3);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(1, jugador.obtenerPuntos());
    }

    @Test
    public void test02JugadorRespondeEnOrdenIncorrectoYNoLeSumaPunto() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionOrdenada();
        Opcion opcion2 = new OpcionOrdenada();
        Opcion opcion3 = new OpcionOrdenada();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice(opciones);

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion3);
        respuestas.add(opcion2);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(0, jugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorNoRespondeTodasLasOpcionesYNoLeSumaPunto() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionOrdenada();
        Opcion opcion2 = new OpcionOrdenada();
        Opcion opcion3 = new OpcionOrdenada();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaOrderedChoice pregunta = new PreguntaOrderedChoice(opciones);

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion2);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(0, jugador.obtenerPuntos());
    }
}
