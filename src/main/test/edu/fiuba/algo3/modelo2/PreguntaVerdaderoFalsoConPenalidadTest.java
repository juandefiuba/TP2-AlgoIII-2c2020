package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.Preguntas.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoConPenalidadTest {
    @Test
    public void test02JugadorRespondeCorrectamenteSumaUnPunto() {
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

        opcionVerdadero.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorRespondeMalRecibePuntoNegativo() {
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

        opcionFalso.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(-1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test04JugadorRespondeCorrectamenteSumaUnPunto() {
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

        opcionFalso.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        //Assert
        assertEquals(1, puntajeDelJugador.obtenerPuntos());
    }

    @Test
    public void test05JugadorRespondeMalRecibePuntoNegativo() {
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

        //jugador.elegirOpcion(opcionVerdadero);
        //jugador.activarMultiplicador();
        opcionVerdadero.agregarJugadorQueLaEligio(jugador);

        //Act
        Puntaje puntajeDelJugador = pregunta.puntuarJugador(jugador);

        assertEquals(-1,puntajeDelJugador.obtenerPuntos());
    }
}
