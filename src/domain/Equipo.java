package domain;

// Generated 06-oct-2010 17:23:23 by Hibernate Tools 3.2.0.b9

import java.util.HashSet;
import java.util.Set;

/**
 * Equipo generated by hbm2java
 */
public class Equipo implements java.io.Serializable {

	private Integer idEquipo;
	private String nombre;
	private String direccion;
	private Set<Jugador> jugadors = new HashSet<Jugador>(0);
	private Set<Partido> partidosForIdEquipoLocal = new HashSet<Partido>(0);
	private Set<Partido> partidosForIdEquipoVisitante = new HashSet<Partido>(0);

	public Equipo() {
	}

	public Equipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Equipo(Integer idEquipo, String nombre, String direccion,
			Set<Jugador> jugadors, Set<Partido> partidosForIdEquipoLocal,
			Set<Partido> partidosForIdEquipoVisitante) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.jugadors = jugadors;
		this.partidosForIdEquipoLocal = partidosForIdEquipoLocal;
		this.partidosForIdEquipoVisitante = partidosForIdEquipoVisitante;
	}

	public Integer getIdEquipo() {
		return this.idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Jugador> getJugadors() {
		return this.jugadors;
	}

	public void setJugadors(Set<Jugador> jugadors) {
		this.jugadors = jugadors;
	}

	public Set<Partido> getPartidosForIdEquipoLocal() {
		return this.partidosForIdEquipoLocal;
	}

	public void setPartidosForIdEquipoLocal(
			Set<Partido> partidosForIdEquipoLocal) {
		this.partidosForIdEquipoLocal = partidosForIdEquipoLocal;
	}

	public Set<Partido> getPartidosForIdEquipoVisitante() {
		return this.partidosForIdEquipoVisitante;
	}

	public void setPartidosForIdEquipoVisitante(
			Set<Partido> partidosForIdEquipoVisitante) {
		this.partidosForIdEquipoVisitante = partidosForIdEquipoVisitante;
	}

	// NECESARIO PARA QUE FUNCIONE EL SELECTONEMENU de editPartido.xhtml
	// JSF comprueba que el item seleccionado se encuentra entre los 
	// objetos a�adidos al selectOneMenu llamando a equals.   
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean igual=false;
		if(obj instanceof Equipo)
			igual= ((Equipo)obj).getIdEquipo()==this.idEquipo;
		if(obj instanceof Integer)
			igual= ((Integer)obj).intValue()==this.idEquipo.intValue();
		return igual;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	

}
