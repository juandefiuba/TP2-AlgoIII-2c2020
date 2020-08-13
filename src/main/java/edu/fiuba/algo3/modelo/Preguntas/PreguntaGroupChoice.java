package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;
import edu.fiuba.algo3.modelo.Puntos.PuntajeValido;
import edu.fiuba.algo3.modelo.Puntos.PuntajeNeutro;
import edu.fiuba.algo3.modelo.Puntos.PuntoEstatico;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class PreguntaGroupChoice extends Pregunta {

    protected Map<Jugador, LinkedList<Opcion>> respuestasGrupoUnoDeLosJugadores;
    protected Map<Jugador, LinkedList<Opcion>> respuestasGrupoDosDeLosJugadores;

    public PreguntaGroupChoice(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
        this.respuestasGrupoUnoDeLosJugadores = new HashMap<>();
        this.respuestasGrupoDosDeLosJugadores = new HashMap<>();
    }

    public Puntaje puntuarJugador(Jugador jugador) {
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
    public void calificarRespuesta(RespondeBien calificador) {
        this.puntajeDelJugador.sumarPuntos(new PuntoEstatico());
    }

    @Override
    public void calificarRespuesta(RespondeMal calificador) {
        this.puntajeDelJugador = new PuntajeNeutro();
    }


    public void agregarRespuestaDeGrupoUnoJugador(Jugador jugador, LinkedList<Opcion> respuestasGrupoUno) {
        this.respuestasGrupoUnoDeLosJugadores.put(jugador,respuestasGrupoUno);
    }

    public void agregarRespuestaDeGrupoDosJugador(Jugador jugador, LinkedList<Opcion> respuestasGrupoDos) {
        this.respuestasGrupoDosDeLosJugadores.put(jugador,respuestasGrupoDos);
    }
}
