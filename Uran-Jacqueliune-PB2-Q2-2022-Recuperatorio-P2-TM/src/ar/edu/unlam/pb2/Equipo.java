package ar.edu.unlam.pb2;

public class Equipo {
	
	private String nombre;
	private String grupos;
	private Integer golesAfavor;
	private Integer golesEnContra;
	private Integer puntaje;
	
	
	
	Equipo(String nombre, String grupos) {
		super();
		this.nombre = nombre;
		this.grupos = grupos;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getGrupos() {
		return grupos;
	}


	public void setGrupos(String grupos) {
		this.grupos = grupos;
	}
	
	public Integer getGolesAfavor() {
		return golesAfavor;
	}


	public void setGolesAfavor(Integer golesAfavor) {
		this.golesAfavor = golesAfavor;
	}


	public Integer getGolesEnContra() {
		return golesEnContra;
	}

	public void setGolesEnContra(Integer golesEnContra) {
		this.golesEnContra = golesEnContra;
	}


	public Integer getPuntaje() {
		return puntaje;
	}


	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}


	
	

}
