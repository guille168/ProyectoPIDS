package com.pids.beans;

import java.io.Serializable;
import java.util.List;

public class Categorizacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codCate;

	private String descripcion;

	private String estado;

	private double montoEntrega;

	// bi-directional many-to-one association to SolicitudAe

	private SolicitudAe solicitudAe;

	// bi-directional many-to-one association to Constancia

	private List<Constancia> constancias;

	public Categorizacion() {

	}

	public int getCodCate() {
		return this.codCate;
	}

	public void setCodCate(int codCate) {
		this.codCate = codCate;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getMontoEntrega() {
		return this.montoEntrega;
	}

	public void setMontoEntrega(double montoEntrega) {
		this.montoEntrega = montoEntrega;
	}

	public SolicitudAe getSolicitudAe() {
		return this.solicitudAe;
	}

	public void setSolicitudAe(SolicitudAe solicitudAe) {
		this.solicitudAe = solicitudAe;
	}

	public List<Constancia> getConstancias() {
		return this.constancias;
	}

	public void setConstancias(List<Constancia> constancias) {
		this.constancias = constancias;
	}

}