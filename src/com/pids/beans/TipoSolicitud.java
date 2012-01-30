package com.pids.beans;

import java.io.Serializable;
import java.util.List;


public class TipoSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;


	private int codTipSol;

	private String descripcion;

	
	private List<Requisito> requisitos;


	private List<SolicitudAe> solicitudAes;

    public TipoSolicitud() {
    }

	public int getCodTipSol() {
		return this.codTipSol;
	}

	public void setCodTipSol(int codTipSol) {
		this.codTipSol = codTipSol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Requisito> getRequisitos() {
		return this.requisitos;
	}

	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}
	
	public List<SolicitudAe> getSolicitudAes() {
		return this.solicitudAes;
	}

	public void setSolicitudAes(List<SolicitudAe> solicitudAes) {
		this.solicitudAes = solicitudAes;
	}
	
}