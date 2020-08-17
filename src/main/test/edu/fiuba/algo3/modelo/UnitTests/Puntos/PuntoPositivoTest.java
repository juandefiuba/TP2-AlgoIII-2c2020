package edu.fiuba.algo3.modelo.UnitTests.Puntos;

import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PuntoPositivoTest {
    @Test
    public void test01PuntoPositivoAlValidarTipoDePuntoSeSumaAlPuntaje(){
        PuntoPositivo unPuntoPositivo = new PuntoPositivo();

        PuntajeValido unPuntajeValido = mock(PuntajeValido.class);

        unPuntoPositivo.validarTipoDePunto(unPuntajeValido);

        verify(unPuntajeValido).sumarPuntos(unPuntoPositivo);
    }
}
