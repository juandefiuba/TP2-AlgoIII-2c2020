package edu.fiuba.algo3.modelo.UnitTests.Exclusividades.Estados;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaDoble;
import edu.fiuba.algo3.modelo.Exclusividades.Estados.ExclusividadValida;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExclusividadValidaTest {
    @Test
    public void test01ExclusividadValidaAlSerAplicadaSobreUnPuntajeSeAplicaCorrectamente(){
        ExclusividadValida unaExclusividadValida = new ExclusividadValida();

        PuntajeValido unPuntajeValidoMock = mock(PuntajeValido.class);
        ExclusividadCompuestaDoble unaExclusividadCompuestaMock = mock(ExclusividadCompuestaDoble.class);

        unaExclusividadValida.aplicarExclusividadAlPuntaje(unaExclusividadCompuestaMock, unPuntajeValidoMock);

        verify(unPuntajeValidoMock).aplicarExclusividad(any(ExclusividadCompuesta.class));
    }
}
