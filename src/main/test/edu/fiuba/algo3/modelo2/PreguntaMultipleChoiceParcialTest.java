package edu.fiuba.algo3.modelo2;
import edu.fiuba.algo3.modelo2.EstadosDeOpcion.Correcto;
import edu.fiuba.algo3.modelo2.EstadosDeOpcion.Incorrecto;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {

    @Test
    public void test01JugadorRespondePreguntaCorrectamente() {
        //Arrange
        Opcion opcion1 = new Opcion(new Incorrecto());
        Opcion opcion2 = new Opcion(new Correcto());
        Opcion opcion3 = new Opcion(new Incorrecto());
        Opcion opcion4 = new Opcion(new Correcto());
        Opcion opcion5 = new Opcion(new Correcto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);
        opciones.agregarOpcion(opcion4);
        opciones.agregarOpcion(opcion5);

        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();
        opcion4 = (Opcion) iteradorDeOpciones.next();
        opcion5 = (Opcion) iteradorDeOpciones.next();

        //Act
        opcion2.agregarJugadorQueLaEligio(jugador);
        opcion4.agregarJugadorQueLaEligio(jugador);
        opcion5.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuarJugadores();

        //Assert
        assertEquals(3,jugador.obtenerPuntos());
    }

}
