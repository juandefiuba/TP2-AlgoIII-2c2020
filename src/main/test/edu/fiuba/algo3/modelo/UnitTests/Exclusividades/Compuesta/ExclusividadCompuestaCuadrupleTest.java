package edu.fiuba.algo3.modelo.UnitTests.Exclusividades.Compuesta;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuestaCuadruple;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExclusividadCompuestaCuadrupleTest {
    @Test
    public void test01UnaExcCompuestaCuadrupleAlAplicarseSobreUnPuntajeSeAplicaLaExclusividadAlPuntaje(){
        ExclusividadCompuestaCuadruple unaExclusividadCompuestaCuadruple = new ExclusividadCompuestaCuadruple();

        PuntajeValido unPuntajeValidoMock = mock(PuntajeValido.class);
        unaExclusividadCompuestaCuadruple.aplicarExclusividad(unPuntajeValidoMock);

        verify(unPuntajeValidoMock).aplicarExclusividad(any(ExclusividadCompuestaCuadruple.class));
    }
}
