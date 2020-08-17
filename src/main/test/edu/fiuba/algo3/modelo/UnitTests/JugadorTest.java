package edu.fiuba.algo3.modelo.UnitTests;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {

    @Test
    public void test01ElJugadorArrancaConCeroPuntos(){
        Jugador unJugador = new Jugador();
        assertEquals( 0 , unJugador.obtenerPuntos());
    }

    @Test
    public void test02ElJugadorSumaUnPuntajeMockCorrectamente(){
        Puntaje puntajeMock = mock(Puntaje.class);
        when(puntajeMock.obtenerPuntos()).thenReturn(3);

        Jugador unJugador = new Jugador();
        unJugador.sumarPuntos(puntajeMock);

        assertEquals(3 , unJugador.obtenerPuntos());
    }

}
