package domain;

// Generated 06-oct-2010 17:23:23 by Hibernate Tools 3.2.0.b9

import java.util.Date;

/**
 * Partido generated by hbm2java
 */
public class Partido implements java.io.Serializable {

	private Integer idPartido;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Integer jornada;
	private Date fecha;
	private Integer golesLocal;
	private Integer golesVisitante;
	private String observaciones;

	public Partido() {
	}

	public Partido(Integer idPartido) {
		this.idPartido = idPartido;
	}

	public Partido(Integer idPartido, Equipo equipoByIdEquipoLocal,
			Equipo equipoByIdEquipoVisitante, Integer jornada, Date fecha,
			Integer golesLocal, Integer golesVisitante, String observaciones) {
		this.idPartido = idPartido;
		this.equipoLocal = equipoByIdEquipoLocal;
		this.equipoVisitante = equipoByIdEquipoVisitante;
		this.jornada = jornada;
		this.fecha = fecha;
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.observaciones = observaciones;
	}

	public Integer getIdPartido() {
		return this.idPartido;
	}

	public void setIdPartido(Integer idPartido) {
		this.idPartido = idPartido;
	}

	public Equipo getEquipoLocal() {
		return this.equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoByIdEquipoLocal) {
		this.equipoLocal = equipoByIdEquipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return this.equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoByIdEquipoVisitante) {
		this.equipoVisitante = equipoByIdEquipoVisitante;
	}

	public Integer getJornada() {
		return this.jornada;
	}

	public void setJornada(Integer jornada) {
		this.jornada = jornada;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getGolesLocal() {
		return this.golesLocal;
	}

	public void setGolesLocal(Integer golesLocal) {
		this.golesLocal = golesLocal;
	}

	public Integer getGolesVisitante() {
		return this.golesVisitante;
	}

	public void setGolesVisitante(Integer golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
