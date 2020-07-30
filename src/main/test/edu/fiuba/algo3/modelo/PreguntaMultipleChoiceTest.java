package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Preguntas.PreguntaMultipleChoiceClasico;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaMultipleChoiceTest {

    @Test
    public void test01ConstructorMultipleChoiceFuncionaCorrectamente() {
        int cantidadOpciones = 3;
        PreguntaMultipleChoiceClasico preguntaPrueba = new PreguntaMultipleChoiceClasico(cantidadOpciones);
        preguntaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.agregarOpcionCorrecta(2);
        assertEquals(3, preguntaPrueba.getCantidadOpciones());
    }

    @Test
    public void test02JugadorRespondeMultipleChoiceCorrectamenteYSeLeAsignaUnPunto() {
        //Arrange
        int cantidadOpciones = 5;
        PreguntaMultipleChoiceClasico preguntaPrueba = new PreguntaMultipleChoiceClasico(cantidadOpciones);
        preguntaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.agregarOpcionCorrecta(2);
        Jugador jugadorPrueba = new Jugador("Messi");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        respuestaPrueba.agregarOpcionElegida(1);
        respuestaPrueba.agregarOpcionElegida(2);
        //Act
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        //Assert
        assertEquals(1, jugadorPrueba.getPuntos());
    }

    @Test
    public void test03JugadorRespondeMultipleChoiceIncorrectamenteYNoSeLeAsignanPuntos() {
        //Arrange
        int cantidadOpciones = 5;
        PreguntaMultipleChoiceClasico preguntaPrueba = new PreguntaMultipleChoiceClasico(cantidadOpciones);
        preguntaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.agregarOpcionCorrecta(2);
        Jugador jugadorPrueba = new Jugador("Higuain");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        respuestaPrueba.agregarOpcionElegida(1);
        respuestaPrueba.agregarOpcionElegida(4);
        //Act
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        //Assert
        assertEquals(0, jugadorPrueba.getPuntos());
    }

    public void test04JugadoresRespondenMultipleChoiceYSeVerificanSusPuntajes() {
        //Arrange
        int cantidadOpciones = 5;
        PreguntaMultipleChoiceClasico preguntaPrueba = new PreguntaMultipleChoiceClasico(cantidadOpciones);
        preguntaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.agregarOpcionCorrecta(2);

        Jugador jugador = new Jugador("Messi");
        Jugador otroJugador = new Jugador("Higuain");

        Respuesta respuestaJugador = preguntaPrueba.getModeloDeRespuesta(jugador);
        Respuesta respuestaOtroJugador = preguntaPrueba.getModeloDeRespuesta(otroJugador);

        respuestaJugador.agregarOpcionElegida(1);
        respuestaJugador.agregarOpcionElegida(2);
        respuestaOtroJugador.agregarOpcionElegida(1);
        respuestaOtroJugador.agregarOpcionElegida(4);

        //Act
        preguntaPrueba.calificarRespuesta(respuestaJugador);
        preguntaPrueba.calificarRespuesta(respuestaOtroJugador);

        //Assert
        assertEquals(1, jugador.getPuntos());
        assertEquals(0, otroJugador.getPuntos());
    }

    /*@Test
    public void test04JugadoresRespondenMultipleChoiceYSeVerificanSusPuntajes() {
        //Arrange
        int cantidadOpciones = 5;
        PreguntaMultipleChoiceClasico preguntaPrueba = new PreguntaMultipleChoiceClasico(cantidadOpciones);
        preguntaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.agregarOpcionCorrecta(2);

        Jugador jugador = new Jugador("Messi");
        Jugador otroJugador = new Jugador("Higuain");

        Respuesta respuestaJugador = preguntaPrueba.getModeloDeRespuesta(jugador);
        Respuesta respuestaOtroJugador = preguntaPrueba.getModeloDeRespuesta(otroJugador);
        respuestaJugador.agregarOpcionCorrecta(1);
        respuestaJugador.agregarOpcionCorrecta(2);

        respuestaOtroJugador.agregarOpcionCorrecta(1);
        respuestaOtroJugador.agregarOpcionCorrecta(4);

        ArrayList<Respuesta> respuestas = new ArrayList<>();

        respuestas.add(respuestaJugador);
        respuestas.add(respuestaOtroJugador);
        //Act
        preguntaPrueba.calificarRespuestasDeJugadores(respuestas);
        //Assert
        assertEquals(1, jugador.getPuntos());
        assertEquals(0, otroJugador.getPuntos());
    }*/

}
