package ar.edu.unlam.pb2;

public class Partido {
	
	private Integer idPartido;
	private Equipo equipoLocal;
	private Equipo equipoRival;
	private TipoDeResultado tipo;
	
	
	public TipoDeResultado getTipo() {
		return tipo;
	}


	public void setTipo(TipoDeResultado tipo) {
		this.tipo = tipo;
	}


	Partido(Integer idPartido, Equipo equipoLocal, Equipo equipoRival) {
		super();
		this.idPartido = idPartido;
		this.equipoLocal = equipoLocal;
		this.equipoRival = equipoRival;
	}


	public Integer getIdPartido() {
		return idPartido;
	}


	public void setIdPartido(Integer idPartido) {
		this.idPartido = idPartido;
	}


	public Equipo getEquipoLocal() {
		return equipoLocal;
	}


	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}


	public Equipo getEquipoRival() {
		return equipoRival;
	}


	public void setEquipoRival(Equipo equipoRival) {
		this.equipoRival = equipoRival;
	}
	


	
	
	
	

	

}
