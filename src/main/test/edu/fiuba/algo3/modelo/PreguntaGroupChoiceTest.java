package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaGroupChoice;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {
    @Test
    public void test01JugadorRespondeGroup() {

        Opcion opcion1 = new OpcionCorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        Opcion opcion4 = new OpcionIncorrecta();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice(opciones);

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

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

        pregunta.agregarRespuestaDeJugador(jugador, respuestasGrupoUno);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestasGrupoUno);


        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(1, jugador.obtenerPuntos());
    }
    @Test
    public void test02JugadorRespondeGroupMal() {

        Opcion opcion1 = new OpcionCorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        Opcion opcion4 = new OpcionIncorrecta();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice(opciones);

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

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


        pregunta.agregarRespuestaDeJugador(jugador, respuestasGrupoUno);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestasGrupoUno);


        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(0, jugador.obtenerPuntos());
    }
    @Test
    public void test03JugadorNoAgrupaTodasLasOpcionesYNoRecibePunto() {

        Opcion opcion1 = new OpcionCorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        Opcion opcion4 = new OpcionIncorrecta();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        PreguntaGroupChoice pregunta = new PreguntaGroupChoice(opciones);

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

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


        pregunta.agregarRespuestaDeJugador(jugador, respuestasGrupoUno);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestasGrupoUno);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(0, jugador.obtenerPuntos());
    }


}
