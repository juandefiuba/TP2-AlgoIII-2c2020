package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion.*;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {
    @Test
    public void test01JugadorRespondeGroup() {

        Opcion opcion1 = new OpcionGrupoUno();
        Opcion opcion2 = new OpcionGrupoDos();
        Opcion opcion3 = new OpcionGrupoUno();
        Opcion opcion4 = new OpcionGrupoDos();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();
        opcion4 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestasGrupoUno = new LinkedList<>();
        LinkedList<Opcion> respuestasGrupoDos = new LinkedList<>();

        respuestasGrupoUno.add(opcion1);
        respuestasGrupoDos.add(opcion2);
        respuestasGrupoUno.add(opcion3);
        respuestasGrupoDos.add(opcion4);

        pregunta.agregarRespuestaDeGrupoUnoJugador(jugador, respuestasGrupoUno);
        pregunta.agregarRespuestaDeGrupoDosJugador(jugador, respuestasGrupoDos);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }
    @Test
    public void test02JugadorRespondeGroupMal() {

        Opcion opcion1 = new OpcionGrupoUno();
        Opcion opcion2 = new OpcionGrupoDos();
        Opcion opcion3 = new OpcionGrupoUno();
        Opcion opcion4 = new OpcionGrupoDos();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();
        opcion4 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestasGrupoUno = new LinkedList<>();
        LinkedList<Opcion> respuestasGrupoDos = new LinkedList<>();

        respuestasGrupoUno.add(opcion1);
        respuestasGrupoUno.add(opcion2);
        respuestasGrupoDos.add(opcion3);
        respuestasGrupoDos.add(opcion4);


        pregunta.agregarRespuestaDeGrupoUnoJugador(jugador, respuestasGrupoUno);
        pregunta.agregarRespuestaDeGrupoDosJugador(jugador, respuestasGrupoDos);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }
    @Test
    public void test03JugadorNoAgrupaTodasLasOpcionesYNoRecibePunto() {

        Opcion opcion1 = new OpcionGrupoUno();
        Opcion opcion2 = new OpcionGrupoDos();
        Opcion opcion3 = new OpcionGrupoUno();
        Opcion opcion4 = new OpcionGrupoDos();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();
        opcion4 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestasGrupoUno = new LinkedList<>();
        LinkedList<Opcion> respuestasGrupoDos = new LinkedList<>();

        respuestasGrupoUno.add(opcion1);
        respuestasGrupoUno.add(opcion2);
        respuestasGrupoDos.add(opcion4);


        pregunta.agregarRespuestaDeGrupoUnoJugador(jugador, respuestasGrupoUno);
        pregunta.agregarRespuestaDeGrupoDosJugador(jugador, respuestasGrupoDos);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }


}
