package edu.fiuba.algo3.modelo;

public class Tildado extends EstadoOpcion {
	
	@Override
	public Boolean estado() {
		return true;
	}
	
	@Override
	public Boolean mismoValor(EstadoOpcion otroEstado) {
		return otroEstado.mismoValor(this);
	}

	@Override
	public Boolean mismoValor(Tildado otroEstado) {
		return true;
	}

	@Override
	public Boolean mismoValor(Destildado otroEstado) {
		return false;
	}

	@Override
	public Integer puntajeObtendido(EstadoOpcion otroEstado) {
		return otroEstado.puntajeObtendido(this);
	}

	@Override
	public Integer puntajeObtenido(Tildado otroEstado) {
		return 1;
	}

	@Override
	public Integer puntajeObtenido(Destildado otroEstado) {
		return 0;
	}

	

}
