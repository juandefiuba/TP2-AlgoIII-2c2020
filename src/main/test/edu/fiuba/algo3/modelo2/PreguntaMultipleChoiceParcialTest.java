package edu.fiuba.algo3.modelo2;
import edu.fiuba.algo3.modelo2.EstadosDeOpcion.Correcto;
import edu.fiuba.algo3.modelo2.EstadosDeOpcion.Incorrecto;
import edu.fiuba.algo3.modelo2.Preguntas.PreguntaMultipleChoiceParcial;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceParcialTest {

   @Test
    public void test01JugadorRespondePreguntaCorrectamenteSoloPrimerOpcion() {
        //Arrange
        Opcion opcion1 = new Opcion(new Correcto());
        Opcion opcion2 = new Opcion(new Incorrecto());
        Opcion opcion3 = new Opcion(new Incorrecto());


        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);


        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        //Act
        opcion1.agregarJugadorQueLaEligio(jugador);

        pregunta.puntuarJugadores();

        //Assert
        assertEquals(1,jugador.obtenerPuntos());
    }

    @Test
    public void test02JugadorRespondePreguntaCorrectamenteSoloSgeundaOpcion() {
        //Arrange
        Opcion opcion1 = new Opcion(new Incorrecto());
        Opcion opcion2 = new Opcion(new Correcto());
        Opcion opcion3 = new Opcion(new Incorrecto());


        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);


        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        //Act
        opcion2.agregarJugadorQueLaEligio(jugador);

        pregunta.puntuarJugadores();

        //Assert
        assertEquals(1,jugador.obtenerPuntos());
    }
    @Test
    public void test03JugadorRespondePreguntaCorrectamenteSoloTercerOpcion() {
        //Arrange
        Opcion opcion1 = new Opcion(new Incorrecto());
        Opcion opcion2 = new Opcion(new Incorrecto());
        Opcion opcion3 = new Opcion(new Correcto());


        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);


        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        //Act
        opcion3.agregarJugadorQueLaEligio(jugador);

        pregunta.puntuarJugadores();

        //Assert
        assertEquals(1,jugador.obtenerPuntos());
    }

    @Test
    public void test04JugadorRespondePreguntaCorrectamenteSoloPrimerYSegundaOpcion() {
        //Arrange
        Opcion opcion1 = new Opcion(new Correcto());
        Opcion opcion2 = new Opcion(new Correcto());
        Opcion opcion3 = new Opcion(new Incorrecto());


        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);


        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        //Act
        opcion1.agregarJugadorQueLaEligio(jugador);
        opcion2.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuarJugadores();

        //Assert
        assertEquals(2,jugador.obtenerPuntos());
    }
    @Test
    public void test05JugadorRespondePreguntaCorrectamenteSoloPrimerYTerceraOpcion() {
        //Arrange
        Opcion opcion1 = new Opcion(new Correcto());
        Opcion opcion2 = new Opcion(new Incorrecto());
        Opcion opcion3 = new Opcion(new Correcto());


        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);


        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        //Act
        opcion1.agregarJugadorQueLaEligio(jugador);
        opcion3.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuarJugadores();

        //Assert
        assertEquals(2,jugador.obtenerPuntos());
    }

  /*  @Test
    public void test06JugadorRespondePreguntaCorrectamenteSoloAciertaUnaDeDosOpciones() {
        //Arrange
        Opcion opcion1 = new Opcion(new Correcto());
        Opcion opcion2 = new Opcion(new Correcto());
        Opcion opcion3 = new Opcion(new Incorrecto());


        ColeccionDeOpciones opciones = new ColeccionDeOpciones();
        opciones.agregarOpcion(opcion1);
        opciones.agregarOpcion(opcion2);
        opciones.agregarOpcion(opcion3);


        PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial(opciones);

        Iterator iteradorDeOpciones = pregunta.obtenerOpciones();

        Jugador jugador = new Jugador("Carlito");
        pregunta.registrarNuevoJugador(jugador);

        opcion1 = (Opcion) iteradorDeOpciones.next();
        opcion2 = (Opcion) iteradorDeOpciones.next();
        opcion3 = (Opcion) iteradorDeOpciones.next();

        //Act
        opcion2.agregarJugadorQueLaEligio(jugador);
        pregunta.puntuarJugadores();

        //Assert
        assertEquals(1,jugador.obtenerPuntos());
    }
*/
}
