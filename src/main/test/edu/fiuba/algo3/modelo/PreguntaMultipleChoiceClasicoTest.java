package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoiceClasico;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceClasicoTest {

    @Test
    public void test01JugadorRespondeMChoiceCorrectamenteYGanaPunto() {
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

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test02JugadorRespondeCorrectamente2OpcionesDeMChoiceCon2OpcionesCorrectasYRecibeUnPunto() {
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

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion2);
        respuestas.add(opcion3);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorRespondeCorrectamente1OpcionDeMChoiceCon2OpcionesCorrectasYNoRecibeUnPunto() {
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

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion2);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test04JugadorRespondeTodasLasOpcionesDeMChoiceCon1OpcionCorrectaYNoRecibeUnPunto() {
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

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion2);
        respuestas.add(opcion3);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test05JugadorRespondeTodasLasOpcionesDeMChoiceConTodasOpcionesCorrectasYRecibeUnPunto() {
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

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion2);
        respuestas.add(opcion3);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test06JugadorResponde2OpcionesCorrectasDeMChoiceConTodasOpcionesCorrectasYNoRecibeUnPunto() {
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

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion3);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(0, puntajeDelJugador.obtenerPuntos());
    }
}
