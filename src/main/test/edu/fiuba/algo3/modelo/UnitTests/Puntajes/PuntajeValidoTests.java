package edu.fiuba.algo3.modelo.UnitTests.Puntajes;

import edu.fiuba.algo3.modelo.Puntos.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntajeValidoTests {

    @Test
    public void test01PuntajeValidoSeInicializaConCeroPuntos(){
        PuntajeValido unPuntaje = new PuntajeValido();
        assertEquals( 0 , unPuntaje.obtenerPuntos() );
    }

    @Test
    public void test02PuntajeValidoIncrementaUnPuntoAlRecibirUnPuntoPositivo(){
        PuntajeValido unPuntaje = new PuntajeValido();
        unPuntaje.sumarPuntos(new PuntoPositivo());
        assertEquals( 1 , unPuntaje.obtenerPuntos());
    }


/*



        @Test
        public void elConductorLaBardeo() {

            IVehiculo vehiculoMock = mock(IVehiculo.class);

            when(vehiculoMock.tocarBocina()).thenReturn(true);
            when(vehiculoMock.frenar()).thenReturn(true);

            Conductor conductor = new Conductor(vehiculoMock);

            boolean ofendido = true;

            Assert.assertTrue(conductor.maniobraFrenadoPacifica(ofendido));

            verify(vehiculoMock,times(1)).tocarBocina();
            verify(vehiculoMock,times(1)).frenar();
        }


        @Test
        public void elConductorEstaTranquilo() {

            IVehiculo vehiculoMock = mock(IVehiculo.class);

            when(vehiculoMock.tocarBocina()).thenReturn(true);
            when(vehiculoMock.frenar()).thenReturn(true);

            Conductor conductor = new Conductor(vehiculoMock);

            boolean ofendido = false;

            Assert.assertTrue(conductor.maniobraFrenadoPacifica(ofendido));

            verify(vehiculoMock,never()).tocarBocina();
            verify(vehiculoMock,times(1)).frenar();
        }*/

}
