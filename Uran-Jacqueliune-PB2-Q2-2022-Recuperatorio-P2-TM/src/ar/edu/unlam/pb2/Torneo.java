package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Torneo {
	
	private List<Partido> listDePartidos = new ArrayList<Partido>();
	private Set<Equipo> listaEquipos = new HashSet<>();
	


	public List<Partido> getListDePartidos() {
		return listDePartidos;
	}

	public void setListDePartidos(List<Partido> listDePartidos) {
		this.listDePartidos = listDePartidos;
	}

	public void agregarEquipos(Equipo equipo1, Equipo equipo2, Equipo equipo3, Equipo equipo4, Equipo equipo5,
			Equipo equipo6, Equipo equipo7, Equipo equipo8, Equipo equipo9, Equipo equipo10, Equipo equipo11,
			Equipo equipo12, Equipo equipo13, Equipo equipo14, Equipo equipo15, Equipo equipo16, Equipo equipo17,
			Equipo equipo18, Equipo equipo19, Equipo equipo20, Equipo equipo21, Equipo equipo22, Equipo equipo23,
			Equipo equipo24, Equipo equipo25, Equipo equipo26, Equipo equipo27, Equipo equipo28, Equipo equipo29,
			Equipo equipo30, Equipo equipo31, Equipo equipo32) {
		
		this.listaEquipos.add(equipo1);
		this.listaEquipos.add(equipo2);
		this.listaEquipos.add(equipo3);
		this.listaEquipos.add(equipo4);
		this.listaEquipos.add(equipo5);
		this.listaEquipos.add(equipo6);
		this.listaEquipos.add(equipo7);
		this.listaEquipos.add(equipo8);
		this.listaEquipos.add(equipo9);
		this.listaEquipos.add(equipo10);
		this.listaEquipos.add(equipo11);
		this.listaEquipos.add(equipo12);
		this.listaEquipos.add(equipo13);
		this.listaEquipos.add(equipo14);
		this.listaEquipos.add(equipo15);
		this.listaEquipos.add(equipo16);
		this.listaEquipos.add(equipo17);
		this.listaEquipos.add(equipo18);
		this.listaEquipos.add(equipo19);
		this.listaEquipos.add(equipo20);
		this.listaEquipos.add(equipo21);
		this.listaEquipos.add(equipo22);
		this.listaEquipos.add(equipo23);
		this.listaEquipos.add(equipo24);
		this.listaEquipos.add(equipo25);
		this.listaEquipos.add(equipo26);
		this.listaEquipos.add(equipo27);
		this.listaEquipos.add(equipo28);
		this.listaEquipos.add(equipo29);
		this.listaEquipos.add(equipo30);
		this.listaEquipos.add(equipo31);
		this.listaEquipos.add(equipo32);

	}
	
	public Integer cantEquipos() {
		
		return listaEquipos.size();
	}
	
	public Integer cantPartidos() {
		return listDePartidos.size();
	}
	
	public Partido obtenerPartidoPorId(Integer idPartido) {
		
		for (Partido partido : listDePartidos) {
			
			if(partido.getIdPartido().equals(idPartido)) {
				return partido;
			}
		}
		return null;
	}

	public Boolean registrarPartido(Integer idPartido, Equipo rival, Equipo local) throws EquipoDuplicadoException, PartidoJugadoException {
		
		Partido partido = new Partido(idPartido,local, rival);
		 	
		if (rival.getNombre().equals(local.getNombre()) || partido.getEquipoLocal() == partido.getEquipoRival()) {
			throw new EquipoDuplicadoException("equipos iguales");
		}
		
		for (Partido partido1 : listDePartidos) {
			
				if(partido1.getEquipoLocal().getNombre() == local.getNombre() && partido1.getEquipoRival().getNombre() == rival.getNombre()) {
					throw new PartidoJugadoException("Partido repetido");
				}
			}
		
		this.listDePartidos.add(partido);
		
		return true;

		
	}

	public boolean registrarEliminatorias(Integer idPartido, Equipo equipoRival, Equipo equipoLocal) throws EquipoDuplicadoException {
		

		if (equipoRival.getNombre().equals(equipoLocal.getNombre())) {
			throw new EquipoDuplicadoException("equipos iguales");
		}
		
		
		Partido partido = new PartidoEliminatorias(1,equipoRival, equipoLocal);
		 
		this.listDePartidos.add(partido);
		
		return true;
	}

	public Boolean registrarResultado(Integer idPartido, Integer golesLocal, Integer golesRival) {
		
		
		Partido partido = obtenerPartidoPorId(idPartido);		
	
			if (golesLocal > golesRival) {
				
				partido.setTipo(TipoDeResultado.GANA_LOCAL);
				
				acumularPuntos(partido, golesLocal, golesRival);				
				return true;			
			}		
			
			if (golesLocal < golesRival) {
				partido.setTipo(TipoDeResultado.GANA_VISITANTE);
				acumularPuntos(partido, golesLocal, golesRival);
				return true;
			}			
			if (golesLocal == golesRival) {
				partido.setTipo(TipoDeResultado.EMPATE);
				acumularPuntos(partido, golesLocal, golesRival);
				return true;
			}
			return false;
		}
	
	public Boolean registrarResultadoPenales(Integer idPartido, Integer golesLocal, Integer golesRival, Integer golesLocalPenal, Integer golesRivalPenal) {
		
		Partido partido = obtenerPartidoPorId(idPartido);		
		
		if (golesLocalPenal > golesRivalPenal) {
			
			partido.setTipo(TipoDeResultado.GANA_LOCAL_PENAL);				
			return true;			
		}		
		
		if (golesLocalPenal < golesRivalPenal) {
			partido.setTipo(TipoDeResultado.GANA_VISITANTE_PENAL);
			return true;
		}			
		
		return null;
		
	}

	private Boolean acumularPuntos(Partido partido, Integer golesLocal, Integer golesRival) {
		
		switch (partido.getTipo()) {
		case GANA_LOCAL: {
			
			Equipo ganador = partido.getEquipoLocal();
			ganador.setGolesAfavor(golesLocal);
			ganador.setGolesEnContra(golesRival);
			
			Integer puntaje = ganador.getPuntaje();
			puntaje += 3;
			ganador.setPuntaje(puntaje);
			
			return true;
		}
		case GANA_VISITANTE: {
			
			Equipo ganador = partido.getEquipoRival();
			ganador.setGolesAfavor(golesRival);
			ganador.setGolesEnContra(golesLocal);
			
			Integer puntaje = ganador.getPuntaje();
			puntaje += 3;
			ganador.setPuntaje(puntaje);
			
			return true;
			
		}
		
		case EMPATE:{
			
			partido.getEquipoLocal().setGolesAfavor(golesLocal);
			partido.getEquipoLocal().setGolesEnContra(golesRival);
						
			partido.getEquipoRival().setGolesAfavor(golesRival);
			partido.getEquipoRival().setGolesEnContra(golesLocal);
			
			Integer puntLocal = partido.getEquipoLocal().getPuntaje();
			puntLocal +=1;
			partido.getEquipoLocal().setPuntaje(puntLocal);
			
			Integer puntRival = partido.getEquipoRival().getPuntaje();
			puntRival +=1;
			partido.getEquipoRival().setPuntaje(puntRival);
			
			return true;
			
		}
		
	}
		return null;
		

	}

	public TipoDeResultado obtenerResultado(Integer idPartido) {
		
		Partido partido = obtenerPartidoPorId(idPartido);
					
		return partido.getTipo();

		
		
	}	

}
