package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.Preguntas.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo2.Preguntas.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicoTest {

    @Test
    public void test01() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionCorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionIncorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        opcion1.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test02() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionCorrecta();
        Opcion opcion3 = new OpcionIncorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        opcion2.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }
    @Test
    public void test03() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        opcion3.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test04() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionCorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        opcion2.agregarJugadorQueLaEligio(jugador);
        opcion3.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test05() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionCorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();


        opcion2.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test06() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionCorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionIncorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        opcion1.agregarJugadorQueLaEligio(jugador);
        opcion2.agregarJugadorQueLaEligio(jugador);
        opcion3.agregarJugadorQueLaEligio(jugador);
        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test07() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionIncorrecta();
        Opcion opcion2 = new OpcionIncorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        opcion1.agregarJugadorQueLaEligio(jugador);
        opcion2.agregarJugadorQueLaEligio(jugador);
        opcion3.agregarJugadorQueLaEligio(jugador);
        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test08() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionCorrecta();
        Opcion opcion2 = new OpcionCorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        opcion1.agregarJugadorQueLaEligio(jugador);
        opcion2.agregarJugadorQueLaEligio(jugador);
        opcion3.agregarJugadorQueLaEligio(jugador);
        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test09() {
        //Arrange se invierten los estados, ahora falso es correcto
        Opcion opcion1 = new OpcionCorrecta();
        Opcion opcion2 = new OpcionCorrecta();
        Opcion opcion3 = new OpcionCorrecta();
        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);

        PreguntaMultipleChoiceClasico pregunta = new PreguntaMultipleChoiceClasico(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        opcion1.agregarJugadorQueLaEligio(jugador);
        //opcion2.agregarJugadorQueLaEligio(jugador);
        opcion3.agregarJugadorQueLaEligio(jugador);
        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }



}
