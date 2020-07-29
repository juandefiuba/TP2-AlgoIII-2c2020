package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Verdadero;
import edu.fiuba.algo3.modelo.EstadosDeOpcion.Falso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaVerdaderoFalsoPenalidadTest {

    @Test
    public void test01ConstructorVerdaderaFuncionaCorrectamente() {
        PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.preguntaVerdadera();
        assertEquals(2, preguntaPrueba.getCantidadOpciones());
        assertEquals(Verdadero.class, (preguntaPrueba.getRespuestaCorrecta()).getClass());
    }
    @Test
    public void test02ConstructorFalsaFuncionaCorrectamente() {
        PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.preguntaFalsa();
        assertEquals(2, preguntaPrueba.getCantidadOpciones());
        assertEquals(Falso.class, (preguntaPrueba.getRespuestaCorrecta()).getClass());
    }

    @Test
    public void test03RespondoCorrectamenteLaPreguntaGano1Punto() {
        PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.preguntaVerdadera();
        Jugador jugadorPrueba = new Jugador("NN");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        respuestaPrueba.agregarOpcionCorrecta(1);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(1, jugadorPrueba.getPuntos());
    }

    @Test
    public void test04RespondoCorrectamenteLaPreguntaGanoMenos1Punto() {
        PreguntaVerdaderoFalsoPenalidad preguntaPrueba = PreguntaVerdaderoFalsoPenalidad.preguntaVerdadera();
        Jugador jugadorPrueba = new Jugador("NN");
        Respuesta respuestaPrueba = preguntaPrueba.getModeloDeRespuesta(jugadorPrueba);
        respuestaPrueba.agregarOpcionCorrecta(0);
        preguntaPrueba.calificarRespuesta(respuestaPrueba);
        assertEquals(-1, jugadorPrueba.getPuntos());
    }

    @Test
    public void test05RespondoIncorrectamente2PreguntasPierde2Puntos() {
        PreguntaVerdaderoFalsoPenalidad preguntaPrueba1 = PreguntaVerdaderoFalsoPenalidad.preguntaVerdadera();
        PreguntaVerdaderoFalsoPenalidad preguntaPrueba2 = PreguntaVerdaderoFalsoPenalidad.preguntaVerdadera();
        Jugador jugadorPrueba = new Jugador("NN");

        Respuesta respuestaPrueba = preguntaPrueba1.getModeloDeRespuesta(jugadorPrueba);
        respuestaPrueba.agregarOpcionCorrecta(0);
        preguntaPrueba1.calificarRespuesta(respuestaPrueba);
        preguntaPrueba2.calificarRespuesta(respuestaPrueba);
        assertEquals(-2, jugadorPrueba.getPuntos());
    }

}
