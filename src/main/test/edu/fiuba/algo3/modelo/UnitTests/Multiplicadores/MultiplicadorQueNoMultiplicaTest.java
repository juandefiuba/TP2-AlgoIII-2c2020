package edu.fiuba.algo3.modelo.UnitTests.Multiplicadores;

import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorQueNoMultiplica;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MultiplicadorQueNoMultiplicaTest {
    @Test
    public void test01UnMultiplicadorQueNoMultiplicaNuncaMultiplicaUnPuntaje(){
        MultiplicadorQueNoMultiplica unMultiplicadorQueNoMultiplica = new MultiplicadorQueNoMultiplica();

        PuntajeValido unPuntajeValido = mock(PuntajeValido.class);

        unMultiplicadorQueNoMultiplica.multiplicar(unPuntajeValido);

        verify(unPuntajeValido).multiplicar(unMultiplicadorQueNoMultiplica);
    }
}
