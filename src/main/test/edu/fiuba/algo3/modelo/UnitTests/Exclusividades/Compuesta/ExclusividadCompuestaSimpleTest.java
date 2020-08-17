package edu.fiuba.algo3.modelo.UnitTests.Exclusividades.Compuesta;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaSimple;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExclusividadCompuestaSimpleTest {
    @Test
    public void test01UnaExcCompuestaSimpleAlAplicarseSobreUnPuntajeSeAplicaLaExclusividadAlPuntaje(){
        ExclusividadCompuestaSimple unaExclusividadCompuestaSimple = new ExclusividadCompuestaSimple();

        PuntajeValido unPuntajeValidoMock = mock(PuntajeValido.class);
        unaExclusividadCompuestaSimple.aplicarExclusividad(unPuntajeValidoMock);

        verify(unPuntajeValidoMock).aplicarExclusividad(any(ExclusividadCompuestaSimple.class));
    }
}
