package edu.fiuba.algo3.modelo.UnitTests.Multiplicadores;

import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MultiplicadorDobleTest {
    @Test
    public void test01UnMultiplicadorDobleMultiplicaCorrectamenteAUnPuntaje(){
        MultiplicadorDoble unMultiplicadorDoble = new MultiplicadorDoble();

        PuntajeValido unPuntajeValido = mock(PuntajeValido.class);

        unMultiplicadorDoble.multiplicar(unPuntajeValido);

        verify(unPuntajeValido).multiplicar(unMultiplicadorDoble);
    }
}
