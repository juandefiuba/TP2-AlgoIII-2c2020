package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.EstadosDeOpcion.Correcto;
import edu.fiuba.algo3.modelo2.EstadosDeOpcion.Incorrecto;
import edu.fiuba.algo3.modelo2.Preguntas.PreguntaVerdaderoFalsoPenalidad;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoConPenalidadTest {
    @Test
    public void test01CrearPreguntaVerdaderoFalso(){
        Opcion opcionVerdadero = new Opcion(new Correcto());
        Opcion opcionFalso = new Opcion(new Incorrecto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        assertEquals(opcionVerdadero, iteradorDeOpciones.next());
    }

    @Test
    public void test02JugadorRespondeCorrectamenteSumaUnPunto() {
        //Arrange
        Opcion opcionVerdadero = new Opcion(new Correcto());
        Opcion opcionFalso = new Opcion(new Incorrecto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");

        pregunta.registrarNuevoJugador(jugador);
        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        //Act
        opcionVerdadero.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuarJugadores();

        //Assert
        assertEquals(1,jugador.obtenerPuntos());
    }

    @Test
    public void test03JugadorRespondeMalSeLeRestaUnPunto() {
        //Arrange
        Opcion opcionVerdadero = new Opcion(new Correcto());
        Opcion opcionFalso = new Opcion(new Incorrecto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        //Act
        opcionFalso.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuarJugadores();

        //Assert
        assertEquals(-1,jugador.obtenerPuntos());
    }
    @Test
    public void test04JugadorRespondeCorrectamenteSumaUnPunto() {
        //Arrange
        Opcion opcionVerdadero = new Opcion(new Incorrecto());
        Opcion opcionFalso = new Opcion(new Correcto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");

        pregunta.registrarNuevoJugador(jugador);
        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        //Act
        opcionFalso.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuarJugadores();

        //Assert
        assertEquals(1,jugador.obtenerPuntos());
    }

    @Test
    public void test05JugadorRespondeMalSeLeRestaUnPunto() {
        //Arrange
        Opcion opcionVerdadero = new Opcion(new Incorrecto());
        Opcion opcionFalso = new Opcion(new Correcto());

        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcionVerdadero);
        opciones.agregarOpcion(opcionFalso);

        PreguntaVerdaderoFalsoPenalidad pregunta = new PreguntaVerdaderoFalsoPenalidad(opciones);

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        opcionVerdadero = (Opcion) iteradorDeOpciones.next();
        opcionFalso = (Opcion) iteradorDeOpciones.next();

        //Act
        opcionVerdadero.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuarJugadores();

        //Assert
        assertEquals(-1,jugador.obtenerPuntos());
    }
}
