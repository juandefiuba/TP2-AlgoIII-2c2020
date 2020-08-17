package edu.fiuba.algo3.modelo.UnitTests.Exclusividades.Compuesta;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaDoble;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ExclusividadCompuestaDobleTest {

    @Test
    public void test01UnaExcCompuestaDobleAlAplicarseSobreUnPuntajeSeAplicaLaExclusividadAlPuntaje(){
        ExclusividadCompuestaDoble unaExclusividadCompuestaDoble = new ExclusividadCompuestaDoble();

        PuntajeValido unPuntajeValidoMock = mock(PuntajeValido.class);
        unaExclusividadCompuestaDoble.aplicarExclusividad(unPuntajeValidoMock);

        verify(unPuntajeValidoMock).aplicarExclusividad(any(ExclusividadCompuestaDoble.class));
    }
}
