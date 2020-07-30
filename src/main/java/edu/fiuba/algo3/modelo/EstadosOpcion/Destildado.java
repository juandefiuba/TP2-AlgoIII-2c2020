package edu.fiuba.algo3.modelo.EstadosOpcion;

public class Destildado implements EstadoOpcion {
	
	@Override
	public Boolean estado() {
		return false;
	}

	@Override
	public Boolean mismoValor(EstadoOpcion otroEstado) {
		return otroEstado.mismoValor(this);
	}
	
	@Override
	public Boolean mismoValor(Tildado otroEstado) {
		return false;
	}

	@Override
	public Boolean mismoValor(Destildado otroEstado) {
		return true;
	}
	
	@Override
	public Integer puntajeObtenido(EstadoOpcion otroEstado) {
		return otroEstado.puntajeObtenido(this);
	}
	
	
	@Override
	public Integer puntajeObtenido(Tildado otroEstado) {
		return 0;
	}

	@Override
	public Integer puntajeObtenido(Destildado otroEstado) {
		return 0;
	}

	

}
