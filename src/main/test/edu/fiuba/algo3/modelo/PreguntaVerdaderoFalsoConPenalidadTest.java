package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionCorrecta;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaVerdaderoFalsoPenalidad;
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

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionVerdadero);

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(1,  jugador.obtenerPuntos());
    }

    @Test
    public void test02JugadorRespondeMalRecibePuntoNegativo() {
        Opcion opcionVerdadero = new OpcionCorrecta();
        Opcion opcionFalso = new OpcionIncorrecta();

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

        respuestas.add(opcionFalso);
        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(-1,  jugador.obtenerPuntos());
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

        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        LinkedList<Opcion> respuestas = new LinkedList<>();

        respuestas.add(opcionFalso);
        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);
        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        //Assert
        assertEquals(1,  jugador.obtenerPuntos());
    }

    @Test
    public void test04JugadorRespondeMalRecibePuntoNegativo() {
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

        pregunta.agregarRespuestaDeJugador(jugador, respuestas);
        pregunta.agregarRespuestaDeJugador(jugador2, respuestas);

        //Act
        pregunta.puntuarJugadores(jugador, jugador2);

        assertEquals(-1, jugador.obtenerPuntos());
    }

    
}
