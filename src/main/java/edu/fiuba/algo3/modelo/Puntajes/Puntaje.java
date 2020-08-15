package edu.fiuba.algo3.modelo.Puntajes;

import edu.fiuba.algo3.modelo.Exclusividad.*;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;
import edu.fiuba.algo3.modelo.Puntos.*;

public interface Puntaje {

    void sumarPuntos(Punto unTipoDePunto);
    void sumarPuntos(PuntoNeutro unTipoDePunto);
    void sumarPuntos(PuntoNegativo unTipoDePunto);
    void sumarPuntos(PuntoPositivo unTipoDePunto);
    void sumarPuntos(PuntoEstatico unTipoDePunto);
    void sumarPuntos(Puntaje unPuntajeAsumar);

    EstadoExclusividad emparejarPuntaje(Puntaje unPuntaje);
    EstadoExclusividad emparejarPuntaje(PuntajeValido unPuntaje);
    EstadoExclusividad emparejarPuntaje(PuntajeNulo unPuntaje);

    void aplicarExclusividad(ExclusividadSimple exclusividadSimple);

    void aplicarExclusividad(ExclusividadDoble exclusividadDoble);

    void aplicarExclusividad(ExclusividadCuadruple exclusividadCuadruple);

    int obtenerPuntos();

    void multiplicar(MultiplicadorTriple multiplicadorTriple);

    void multiplicar(MultiplicadorDoble multiplicadorDoble);

    void aplicarExclusividad(ExclusividadDeEmpate exclusividadDeEmpate);
}