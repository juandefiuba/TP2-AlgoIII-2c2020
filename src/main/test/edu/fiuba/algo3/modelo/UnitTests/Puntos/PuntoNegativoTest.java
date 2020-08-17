package edu.fiuba.algo3.modelo.UnitTests.Puntos;

import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoNegativo;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PuntoNegativoTest {
    @Test
    public void test01PuntoNegativoAlValidarTipoDePuntoSeSumaAlPuntaje(){
        PuntoNegativo unPuntoNegativo = new PuntoNegativo();

        PuntajeValido unPuntajeValido = mock(PuntajeValido.class);

        unPuntoNegativo.validarTipoDePunto(unPuntajeValido);

        verify(unPuntajeValido).sumarPuntos(unPuntoNegativo);
    }
}
