package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoicePenalidad;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalsoPenalidad;

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

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();


        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        jugador.activarMultiplicadorPorDos();

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        assertEquals(-2,jugador.obtenerPuntos());
    }

    @Test
    public void test02JugadorActivaUnMultiplicadorPorTresYRespondeIncorrectamenteLaPreguntaYRecibeTresPuntosNegativos() {
        Opcion opcionVerdadero = new OpcionIncorrecta();
        Opcion opcionFalso = new OpcionCorrecta();

        LinkedList<Opcion> opciones = new LinkedList<>();
        opciones.add(opcionVerdadero);
        opciones.add(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();


        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        jugador.activarMultiplicadorPorTres();

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        assertEquals(-3,jugador.obtenerPuntos());
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

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();


        Iterator iteradorDeOpciones = preguntaUno.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        jugador.activarMultiplicadorPorTres();

        preguntaUno.agregarRespuestaDeJugador(jugador, respuestas);
        preguntaUno.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        preguntaUno.puntuarJugadores(jugador, jugador2);

        assertEquals(-3,jugador.obtenerPuntos());

        iteradorDeOpciones = preguntaDos.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        jugador.activarMultiplicadorPorTres();

        preguntaDos.agregarRespuestaDeJugador(jugador, respuestas);
        preguntaDos.agregarRespuestaDeJugador(jugador2, respuestas);

        preguntaDos.puntuarJugadores(jugador, jugador2);

        assertEquals(-4,jugador.obtenerPuntos());
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

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion2);

        jugador.activarMultiplicadorPorDos();

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(-4, jugador.obtenerPuntos());
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

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcion1);
        respuestas.add(opcion2);

        jugador.activarMultiplicadorPorTres();

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(-6, jugador.obtenerPuntos());
    }
}



