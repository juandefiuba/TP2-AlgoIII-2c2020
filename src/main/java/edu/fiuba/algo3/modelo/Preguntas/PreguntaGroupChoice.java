package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntos.PuntoEstatico;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class PreguntaGroupChoice extends PreguntaBase {

    protected Map<Jugador, LinkedList<Opcion>> respuestasGrupoUnoDeLosJugadores;
    protected Map<Jugador, LinkedList<Opcion>> respuestasGrupoDosDeLosJugadores;


    public PreguntaGroupChoice(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
        this.respuestasGrupoUnoDeLosJugadores = new HashMap<>();
        this.respuestasGrupoDosDeLosJugadores = new HashMap<>();
    }

    public Puntaje obtenerPuntajeBaseDelJugador(Jugador jugador) {
        this.puntajeDelJugador = new PuntajeValido();
        LinkedList<Opcion> respuestaDelJugadorGrupoUno = this.respuestasGrupoUnoDeLosJugadores.get(jugador);
        LinkedList<Opcion> respuestaDelJugadorGrupoDos = this.respuestasGrupoDosDeLosJugadores.get(jugador);

        LinkedList<Opcion> opcionesGrupoUno = new LinkedList<>();
        LinkedList<Opcion> opcionesGrupoDos = new LinkedList<>();

        opciones.forEach(opcion -> opcion.enlistarGrupoUno(opcionesGrupoUno));
        opciones.forEach(opcion -> opcion.enlistarGrupoDos(opcionesGrupoDos));

        Iterator iterador = opcionesGrupoUno.iterator();

        while (iterador.hasNext()){
            if(!respuestaDelJugadorGrupoUno.contains(iterador.next())){
                this.calificarRespuesta(new RespondeMal());
            }
        }

        iterador = respuestaDelJugadorGrupoDos.iterator();

        while (iterador.hasNext()){
            if(!respuestaDelJugadorGrupoDos.contains(iterador.next())){
                this.calificarRespuesta(new RespondeMal());
            }
        }
        this.calificarRespuesta(new RespondeBien());
        return this.puntajeDelJugador;
    }

    @Override
    public void puntuarJugadores(Jugador jugador, Jugador jugador2) {
        Puntaje puntajeJugador = this.obtenerPuntajeBaseDelJugador(jugador);
        Puntaje puntajeJugador2 = this.obtenerPuntajeBaseDelJugador(jugador2);

        Exclusividad exclusividad = jugador.obtenerExclusividad();
        Exclusividad exclusividad2 = jugador2.obtenerExclusividad();

        Exclusividad exclusividadParcial1 = exclusividad2.componerExclusividad(exclusividad);

        EstadoExclusividad exclusividadParcial2 = puntajeJugador.emparejarPuntaje(puntajeJugador2);

        Exclusividad exclusividadTotal = exclusividadParcial1.validarExclusividad(exclusividadParcial2);

        exclusividadTotal.aplicarExclusividad(puntajeJugador);
        exclusividadTotal.aplicarExclusividad(puntajeJugador2);

        jugador.sumarPuntos(puntajeJugador);
        jugador2.sumarPuntos(puntajeJugador2);
    }

    @Override
    public void calificarRespuesta(RespondeBien calificador) {
        this.puntajeDelJugador.sumarPuntos(new PuntoEstatico());
    }

    @Override
    public void calificarRespuesta(RespondeMal calificador) {
        this.puntajeDelJugador = new PuntajeNulo();
    }


    public void agregarRespuestaDeGrupoUnoJugador(Jugador jugador, LinkedList<Opcion> respuestasGrupoUno) {
        this.respuestasGrupoUnoDeLosJugadores.put(jugador,respuestasGrupoUno);
    }

    public void agregarRespuestaDeGrupoDosJugador(Jugador jugador, LinkedList<Opcion> respuestasGrupoDos) {
        this.respuestasGrupoDosDeLosJugadores.put(jugador,respuestasGrupoDos);
    }

}
