package edu.fiuba.algo3.modelo.Puntos;

import edu.fiuba.algo3.modelo.Exclusividad.*;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDoble;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorTriple;

public interface Puntaje {

    void sumarPuntos(Punto unTipoDePunto);
    void sumarPuntos(PuntoNeutro unTipoDePunto);
    void sumarPuntos(PuntoNegativo unTipoDePunto);
    void sumarPuntos(PuntoPositivo unTipoDePunto);
    void sumarPuntos(PuntoEstatico unTipoDePunto);
    void sumarPuntos(PuntajeValido unPuntajeAsumar);

    EstadoExclusividad emparejarPuntaje(Puntaje unPuntaje);
    EstadoExclusividad emparejarPuntaje(PuntajeValido unPuntaje);
    EstadoExclusividad emparejarPuntaje(PuntajeNeutro unPuntaje);

    void aplicarExclusividad(ExclusividadSimple exclusividadSimple);

    void aplicarExclusividad(ExclusividadDoble exclusividadDoble);

    void aplicarExclusividad(ExclisividadCuadruple exclisividadCuadruple);

    int obtenerPuntos();

    void multiplicar(MultiplicadorTriple multiplicadorTriple);

    void multiplicar(MultiplicadorDoble multiplicadorDoble);

    void aplicarExclusividad(ExclusividadDeEmpate exclusividadDeEmpate);
}