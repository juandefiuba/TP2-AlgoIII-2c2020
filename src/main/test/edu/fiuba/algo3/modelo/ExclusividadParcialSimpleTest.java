package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcialDoble;
import edu.fiuba.algo3.modelo.Exclusividades.Parcial.ExclusividadParcialSimple;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadParcialSimpleTest {
    @Test
    public void test01UnaExcParcialSimpleCompuestaConUnaExcParcialSimpleAlAplicarAUnPuntajeConUnPuntoNoModificaLosPuntos(){
        //Arrange
        ExclusividadParcialSimple unaExclusividadParcialSimple = new ExclusividadParcialSimple();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcialSimple.componerExclusividad(new ExclusividadParcialSimple());

        PuntajeValido unPuntajeValido = new PuntajeValido();
        unPuntajeValido.sumarPuntos(new PuntoPositivo());
        //Act
        unPuntajeValido.aplicarExclusividad(exclusividadCompuesta);

        assertEquals(1, unPuntajeValido.obtenerPuntos());
    }

    @Test
    public void test02UnaExcParcialSimpleCompuestaConUnaExcParcialDobleAlAplicarAUnPuntajeConUnPuntoDuplicaLosPuntos(){
        //Arrange
        ExclusividadParcialSimple unaExclusividadParcialSimple = new ExclusividadParcialSimple();

        ExclusividadCompuesta exclusividadCompuesta = unaExclusividadParcialSimple.componerExclusividad(new ExclusividadParcialDoble());

        PuntajeValido unPuntajeValido = new PuntajeValido();
        unPuntajeValido.sumarPuntos(new PuntoPositivo());
        //Act
        unPuntajeValido.aplicarExclusividad(exclusividadCompuesta);

        assertEquals(2, unPuntajeValido.obtenerPuntos());
    }
}
