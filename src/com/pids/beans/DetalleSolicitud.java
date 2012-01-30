package com.pids.beans;

import java.io.Serializable;


/**
 * The persistent class for the detalle_solicitud database table.
 * 
 */

public class DetalleSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idDetalle_Solicitud;


	private String imagen;

	//bi-directional many-to-one association to SolicitudAe
   
	private SolicitudAe solicitudAe;

	//bi-directional many-to-one association to Requisito

	private Requisito requisito;

    public DetalleSolicitud() {
    }

	public int getIdDetalle_Solicitud() {
		return this.idDetalle_Solicitud;
	}

	public void setIdDetalle_Solicitud(int idDetalle_Solicitud) {
		this.idDetalle_Solicitud = idDetalle_Solicitud;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public SolicitudAe getSolicitudAe() {
		return this.solicitudAe;
	}

	public void setSolicitudAe(SolicitudAe solicitudAe) {
		this.solicitudAe = solicitudAe;
	}
	
	public Requisito getRequisito() {
		return this.requisito;
	}

	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}
	
}