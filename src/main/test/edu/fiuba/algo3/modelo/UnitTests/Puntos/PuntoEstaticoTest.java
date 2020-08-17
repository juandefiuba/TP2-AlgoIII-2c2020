package edu.fiuba.algo3.modelo.UnitTests.Puntos;

import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoEstatico;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PuntoEstaticoTest {
    @Test
    public void test01PuntoEstaticoAlValidarTipoDePuntoSeSumaAlPuntaje(){
        PuntoEstatico unPuntoEstatico = new PuntoEstatico();

        PuntajeValido unPuntajeValido = mock(PuntajeValido.class);

        unPuntoEstatico.validarTipoDePunto(unPuntajeValido);

        verify(unPuntajeValido).sumarPuntos(unPuntoEstatico);
    }
}
