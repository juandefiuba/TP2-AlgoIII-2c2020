package edu.fiuba.algo3.modelo.UnitTests.Exclusividades.Estados;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaDoble;
import edu.fiuba.algo3.modelo.Exclusividades.Estados.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExclusividadInvalidaTest {
    @Test
    public void test01ExclusividadInvalidaAlSerAplicadaSobreUnPuntajeSeAplicaCorrectamente(){
        ExclusividadInvalida unaExclusividadInvalida = new ExclusividadInvalida();

        PuntajeValido unPuntajeValidoMock = mock(PuntajeValido.class);
        ExclusividadCompuestaDoble unaExclusividadCompuestaMock = mock(ExclusividadCompuestaDoble.class);

        unaExclusividadInvalida.aplicarExclusividadAlPuntaje(unaExclusividadCompuestaMock, unPuntajeValidoMock);

        verify(unPuntajeValidoMock).aplicarExclusividad(unaExclusividadInvalida);
    }
}
