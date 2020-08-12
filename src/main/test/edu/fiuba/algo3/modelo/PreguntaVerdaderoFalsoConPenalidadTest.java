package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opcion.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoConPenalidadTest {
    @Test
    public void test01JugadorRespondeCorrectamenteSumaUnPunto() {
        //Arrange
        Opcion opcionVerdadero = new OpcionCorrecta();
        Opcion opcionFalso = new OpcionIncorrecta();

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

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test02JugadorRespondeMalRecibePuntoNegativo() {
        Opcion opcionVerdadero = new OpcionCorrecta();
        Opcion opcionFalso = new OpcionIncorrecta();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcionVerdadero);
        opciones.add(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionFalso);
        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(-1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorRespondeCorrectamenteSumaUnPunto() {
        //Arrange se invierten los estados, ahora falso es correcto
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

        respuestas.add(opcionFalso);
        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test04JugadorRespondeMalRecibePuntoNegativo() {
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

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        assertEquals(-1,puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test05JugadorActivaUnMultiplicadorPorDosYRespondeIncorrectamenteLaPreguntaYRecibeDosPuntosNegativos() {
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
    public void test06JugadorActivaUnMultiplicadorPorTresYRespondeIncorrectamenteLaPreguntaYRecibeTresPuntosNegativos() {
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
    public void test07JugadorActivaDosVecesSuMultiplicadorContestandoDosPreguntasYSeVerificaQueSoloSeAplicoUnMultiplicador() {
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
}
