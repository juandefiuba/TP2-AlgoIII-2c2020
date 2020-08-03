package edu.fiuba.algo3.modelo2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoConPenalidadTest {
    @Test
    public void test01CrearPreguntaVerdaderoFalso(){
        Opcion opcionVerdadero = new Opcion(new IncorrectoConPenalidad());
        Opcion opcionFalso = new Opcion(new Correcto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);

        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        assertEquals(opcionVerdadero, iteradorDeOpciones.next());
    }

    @Test
    public void test02JugadorRespondePreguntaCorrectamente() {
        //Arrange
        Opcion opcionVerdadero = new Opcion(new IncorrectoConPenalidad());
        Opcion opcionFalso = new Opcion(new Correcto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);

        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        //Act
        opcionFalso.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuar();

        //Assert
        assertEquals(1,jugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorRespondeMalSeLeRestaUnPunto() {
        //Arrange
        Opcion opcionVerdadero = new Opcion(new IncorrectoConPenalidad());
        Opcion opcionFalso = new Opcion(new Correcto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);

        PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso(opciones);

        Jugador jugador = new Jugador("Carlito");

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        //Act
        opcionVerdadero.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuar();

        //Assert
        assertEquals(-1,jugador.obtenerPuntos());
    }
}
