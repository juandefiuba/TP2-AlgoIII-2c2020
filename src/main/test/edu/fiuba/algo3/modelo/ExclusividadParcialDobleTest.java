package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcialDoble;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcialSimple;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadParcialDobleTest {
    @Test
    public void test01UnaExcParcialDobleCompuestaConUnaExcParcialSimpleAlAplicarAUnPuntajeConUnPuntoDuplicaLosPuntos(){
        ExclusividadParcialDoble unaExclusividadParcialDoble = new ExclusividadParcialDoble();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcialDoble.componerExclusividad(new ExclusividadParcialSimple());

        PuntajeValido unPuntajeValido = new PuntajeValido();
        unPuntajeValido.sumarPuntos(new PuntoPositivo());

        unPuntajeValido.aplicarExclusividad(exclusividadCompuesta);

        assertEquals(2, unPuntajeValido.obtenerPuntos());
    }

    @Test
    public void test02UnaExcParcialDobleCompuestaConUnaExcParcialDobleAlAplicarAUnPuntajeConUnPuntoCuadriplicaLosPuntos(){
        ExclusividadParcialDoble unaExclusividadParcialDoble = new ExclusividadParcialDoble();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcialDoble.componerExclusividad(new ExclusividadParcialDoble());

        PuntajeValido unPuntajeValido = new PuntajeValido();
        unPuntajeValido.sumarPuntos(new PuntoPositivo());

        unPuntajeValido.aplicarExclusividad(exclusividadCompuesta);

        assertEquals(4, unPuntajeValido.obtenerPuntos());
    }
}
