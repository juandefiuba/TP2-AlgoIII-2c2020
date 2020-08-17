package edu.fiuba.algo3.modelo.UnitTests.Puntos;

import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoNeutro;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PuntoNeutroTest {
    @Test
    public void test01PuntoNeutroAlValidarTipoDePuntoSeSumaAlPuntaje(){
        PuntoNeutro unPuntoNeutro = new PuntoNeutro();

        PuntajeValido unPuntajeValido = mock(PuntajeValido.class);

        unPuntoNeutro.validarTipoDePunto(unPuntajeValido);

        verify(unPuntajeValido).sumarPuntos(unPuntoNeutro);
    }
}
