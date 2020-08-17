package edu.fiuba.algo3.modelo.UnitTests.Multiplicadores;

import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MultiplicadorTripleTest {
    @Test
    public void test01UnMultiplicadorTripleMultiplicaCorrectamenteAUnPuntaje(){
        MultiplicadorTriple unMultiplicadorTriple = new MultiplicadorTriple();

        PuntajeValido unPuntajeValido = mock(PuntajeValido.class);

        unMultiplicadorTriple.multiplicar(unPuntajeValido);

        verify(unPuntajeValido).multiplicar(unMultiplicadorTriple);
    }
}
