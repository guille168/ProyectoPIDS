package com.pids.beans;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the requisito database table.
 * 
 */

public class Requisito implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int codReqAnx;

	private String descripcion;

	private String tipo;

	//bi-directional many-to-one association to DetalleSolicitud

	private List<DetalleSolicitud> detalleSolicituds;

	//bi-directional many-to-many association to TipoSolicitud
    
	private List<TipoSolicitud> tipoSolicituds;

    public Requisito() {
    }

	public int getCodReqAnx() {
		return this.codReqAnx;
	}

	public void setCodReqAnx(int codReqAnx) {
		this.codReqAnx = codReqAnx;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<DetalleSolicitud> getDetalleSolicituds() {
		return this.detalleSolicituds;
	}

	public void setDetalleSolicituds(List<DetalleSolicitud> detalleSolicituds) {
		this.detalleSolicituds = detalleSolicituds;
	}
	
	public List<TipoSolicitud> getTipoSolicituds() {
		return this.tipoSolicituds;
	}

	public void setTipoSolicituds(List<TipoSolicitud> tipoSolicituds) {
		this.tipoSolicituds = tipoSolicituds;
	}
	
}