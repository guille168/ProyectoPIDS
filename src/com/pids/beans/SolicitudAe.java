package com.pids.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the solicitud_ae database table.
 * 
 */
public class SolicitudAe implements Serializable {
	private static final long serialVersionUID = 1L;

	private int numSolicitud;

	private String estado;

	private Date fecha;

	// bi-directional many-to-one association to Categorizacion

	private List<Categorizacion> categorizacions;

	// bi-directional many-to-one association to DetalleSolicitud

	private List<DetalleSolicitud> detalleSolicituds;

	// bi-directional many-to-one association to TipoSolicitud

	private TipoSolicitud tipoSolicitud;

	// bi-directional many-to-one association to Universitario

	private Universitario universitario;

	// bi-directional many-to-one association to Trabajador

	private Trabajador trabajador;

	public SolicitudAe() {
	}

	public int getNumSolicitud() {
		return this.numSolicitud;
	}

	public void setNumSolicitud(int numSolicitud) {
		this.numSolicitud = numSolicitud;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Categorizacion> getCategorizacions() {
		return this.categorizacions;
	}

	public void setCategorizacions(List<Categorizacion> categorizacions) {
		this.categorizacions = categorizacions;
	}

	public List<DetalleSolicitud> getDetalleSolicituds() {
		return this.detalleSolicituds;
	}

	public void setDetalleSolicituds(List<DetalleSolicitud> detalleSolicituds) {
		this.detalleSolicituds = detalleSolicituds;
	}

	public TipoSolicitud getTipoSolicitud() {
		return this.tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public Universitario getUniversitario() {
		return this.universitario;
	}

	public void setUniversitario(Universitario universitario) {
		this.universitario = universitario;
	}

	public Trabajador getTrabajador() {
		return this.trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

}