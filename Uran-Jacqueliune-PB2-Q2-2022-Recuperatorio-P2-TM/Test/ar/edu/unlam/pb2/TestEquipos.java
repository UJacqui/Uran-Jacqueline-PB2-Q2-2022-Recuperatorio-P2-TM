package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class TestEquipos {

	@Test
	public void queSePuedaCrearUnTorneoCon32Equipos() {

		Torneo torneo = new Torneo();
		
		Equipo equipo1 = new Equipo("quatar", "grupo1");
		Equipo equipo2 = new Equipo ("quatar", "grupo1");
		Equipo equipo3 = new Equipo("quatar", "grupo1");
		Equipo equipo4 = new Equipo ("quatar", "grupo1");
		Equipo equipo5 = new Equipo("quatar", "grupo2");
		Equipo equipo6 = new Equipo ("quatar", "grupo2");
		Equipo equipo7 = new Equipo("quatar", "grupo2");
		Equipo equipo8 = new Equipo ("quatar", "grupo2");
		Equipo equipo9 = new Equipo("quatar", "grupo3");
		Equipo equipo10 = new Equipo ("quatar", "grupo3");
		Equipo equipo11 = new Equipo("quatar", "grupo3");
		Equipo equipo12 = new Equipo ("quatar", "grupo3");
		Equipo equipo13 = new Equipo("quatar", "grupo4");
		Equipo equipo14 = new Equipo ("quatar", "grupo4");
		Equipo equipo15 = new Equipo("quatar", "grupo4");
		Equipo equipo16 = new Equipo ("quatar", "grupo4");
		Equipo equipo17 = new Equipo("quatar", "grupo5");
		Equipo equipo18 = new Equipo ("quatar", "grupo5");
		Equipo equipo19 = new Equipo("quatar", "grupo5");
		Equipo equipo20 = new Equipo ("quatar", "grupo5");
		Equipo equipo21 = new Equipo("quatar", "grupo5");
		Equipo equipo22 = new Equipo ("quatar", "grupo5");
		Equipo equipo23 = new Equipo("quatar", "grupo6");
		Equipo equipo24 = new Equipo ("quatar", "grupo6");
		Equipo equipo25 = new Equipo("quatar", "grupo6");
		Equipo equipo26 = new Equipo ("quatar", "grupo6");
		Equipo equipo27 = new Equipo("quatar", "grupo7");
		Equipo equipo28 = new Equipo ("quatar", "grupo7");
		Equipo equipo29 = new Equipo("quatar", "grupo7");
		Equipo equipo30 = new Equipo ("quatar", "grupo7");
		Equipo equipo31 = new Equipo("quatar", "grupo8");
		Equipo equipo32 = new Equipo ("quatar", "grupo8");
				 
		torneo.agregarEquipos(equipo1,equipo2, equipo3,equipo4, equipo5, equipo6, equipo7, equipo8,equipo9,equipo10,
				equipo11,equipo12, equipo13,equipo14, equipo15, equipo16, equipo17, equipo18,equipo19,equipo20,
				equipo21,equipo22, equipo23,equipo24, equipo25, equipo26, equipo27, equipo28,equipo29,equipo30,
				equipo31,equipo32);
		
		Integer cantEsperada =32;
		
		assertEquals(cantEsperada, torneo.cantEquipos());
		
	}
	

	@Test
	public void queSePuedaCrearUnPartidoDeGruposConDosEquiposDelMismoGrupo() throws EquipoDuplicadoException, PartidoJugadoException {
		
		Torneo torneo = new Torneo();
		
		Equipo equipoRival = new Equipo("argentina", "grupo8");
		Equipo equipoLocal = new Equipo("Quatar", "grupo8");
		Partido grupos = new PartidoGrupo(3,equipoRival, equipoLocal);
			 
		Boolean partidoObtenido = torneo.registrarPartido(grupos.getIdPartido(), equipoRival, equipoLocal);
	
	 	assertTrue(partidoObtenido);
	}
	
	@Test
	public void queSePuedaCrearUnPartidoDeEliminatoriasConDosEquiposPertenecientesALaListaDeEquiposEnEliminatorias() throws EquipoDuplicadoException, PartidoJugadoException {
		
		Torneo torneo = new Torneo();
		
		Equipo equipoRival = new Equipo("argentina", "grupo8");
		Equipo equipoLocal = new Equipo("Quatar", "grupo8");
		Partido partido = new Partido(1,equipoRival, equipoLocal);
		
		torneo.registrarPartido(partido.getIdPartido(), equipoRival, equipoLocal);
	 
		Partido eliminatorias = new PartidoEliminatorias(2,equipoRival, equipoLocal);
		
		Boolean EliminatoriosRegistrados=torneo.registrarEliminatorias(2,equipoRival, equipoLocal);
		
		assertTrue(EliminatoriosRegistrados);
		
	}
	
	@Test (expected = PartidoJugadoException.class)
	public void queAlCrearUnPartidoDondeLosEquiposYaJugaronSeLanceUnPartidoJugadoException() throws EquipoDuplicadoException, PartidoJugadoException {
		Torneo torneo = new Torneo();
		
		Equipo equipoRival = new Equipo("argentina", "grupo8");
		Equipo equipoLocal = new Equipo("Quatar", "grupo8");

		torneo.registrarPartido(1, equipoRival, equipoLocal);
		torneo.registrarPartido(2, equipoRival, equipoLocal);
		
	}
	@Test (expected = EquipoDuplicadoException.class)
	public void queAlCrearUnPartidoDeGruposDondeElEquipoLocalEsElMismoQueElEquipoRivalSeLanceUnEquipoDuplicadoException() throws EquipoDuplicadoException, PartidoJugadoException {
		
		// equipo local = equipo rival
		
		Torneo torneo = new Torneo();
		
		Equipo local = new Equipo("argentina", "grupo8");
		
		Partido grupos = new PartidoGrupo(3,local, local);

		torneo.registrarPartido(1, local, local);

	}
	
	@Test
	public void queAlRegistrarElResultadoDeUnPartidoDeGruposSeAcumulenLosPuntosCorrespondientesACadaEquipo() throws EquipoDuplicadoException, PartidoJugadoException {
		
		Torneo torneo = new Torneo();
	
		Equipo equipoRival = new Equipo("argentina", "grupo8");
		Equipo equipoLocal = new Equipo("Quatar", "grupo8");
		Partido grupos = new PartidoGrupo(1,equipoRival, equipoLocal);
		
		equipoRival.setPuntaje(0);
		equipoLocal.setPuntaje(0);
		
		Integer golesLocal = 2;	
		Integer golesVisitantes = 1;
		
		Integer puntosEsperado = 3;
		
		torneo.registrarPartido(1,equipoRival,equipoLocal);
		torneo.registrarResultado(1, golesLocal,golesVisitantes);

		assertEquals(puntosEsperado, grupos.getEquipoRival().getPuntaje());
		
	}
	@Test
	public void queAlObtenerElResultadoDeUnPartidoDeGruposSeaElElementoEmpateDelEnum() throws EquipoDuplicadoException, PartidoJugadoException {
		
		Torneo torneo = new Torneo();
		
		Equipo equipoRival = new Equipo("argentina", "grupo8");
		Equipo equipoLocal = new Equipo("Quatar", "grupo8");
		Partido grupos = new PartidoGrupo(1,equipoRival, equipoLocal);
		
		equipoRival.setPuntaje(0);
		equipoLocal.setPuntaje(0);
		
		Integer golesLocal = 1;	
		Integer golesVisitantes = 1;
		
		
		torneo.registrarPartido(1,equipoRival,equipoLocal);
		torneo.registrarResultado(1, golesLocal,golesVisitantes);
		
		TipoDeResultado tipoObtenido = torneo.obtenerResultado(grupos.getIdPartido());
		
				
		assertEquals(TipoDeResultado.EMPATE, tipoObtenido);

		
	}
	@Test
	public void queAlObtenerElResultadoDeUnPartidoDeEliminatoriasEnCasoDeEmpateSeObtengaElEnumDelGanadorPorPenales() throws EquipoDuplicadoException, PartidoJugadoException {
		
		//Cuando un partido es de eliminatoria, si resultó en empate, se deben registrar los penales
		//consumiendo el método registrarResultado(idPartido, golesLocal, golesVisitantes,
		//penalesConvertidosLocal, penalesConvertidosVisitante).
		Torneo torneo = new Torneo();
		
		Equipo equipoRival = new Equipo("argentina", "grupo8");
		Equipo equipoLocal = new Equipo("Quatar", "grupo8");
		Partido eliminatorias = new PartidoEliminatorias(1,equipoRival, equipoLocal);		
		
		Integer golesLocal = 1;	
		Integer golesRival = 1;
		
		Integer golesLocalPenal = 3;
		Integer golesRivalPenal = 2;
		
		torneo.registrarPartido(1,equipoRival,equipoLocal);
		torneo.registrarResultadoPenales(1, golesLocal, golesRival, golesLocalPenal, golesRivalPenal);
		
		
		TipoDeResultado tipoObtenido = torneo.obtenerResultado(eliminatorias.getIdPartido());
		
		assertEquals(TipoDeResultado.GANA_LOCAL_PENAL, tipoObtenido);
		
	}
	
	@Test
	public void queAlConsultarPuntajeDeEquiposDeLosGrupoSeObtenganLosEquiposOrdenadosPorGrupoAscendenteYPorPuntosDescendentemente() {
		
		//treeSet ordenado por puntaje Y Grupos
		
		
	}
	
	@Test
	public void queAlFinalizarLaFaseDeGruposSeAgreguenLosMejores2EquiposDeCadaGrupoALaColeccionDeEquiposEnEliminatorias() {
		
		/*En el torneo se debe permitir finalizar la fase de grupos el cual asigna a la colección de
equipos en eliminatorias, los equipos que pasan a la fase de eliminatorias (Los equipos que
pasan a la fase de eliminatorias son los dos primeros en puntaje de cada grupo).*/
			
		
		
		
	}
	
	
	
	
	
	
	


}
