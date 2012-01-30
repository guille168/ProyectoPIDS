package com.pids.beans;

import java.io.Serializable;
import java.util.Date;


public class Constancia implements Serializable {
	private static final long serialVersionUID = 1L;

	private int codCon;

	private String estado;


	private Date fecha;

	private double monto;


	private Categorizacion categorizacion;

    public Constancia() {
    }

	public int getCodCon() {
		return this.codCon;
	}

	public void setCodCon(int codCon) {
		this.codCon = codCon;
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

	public double getMonto() {
		return this.monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Categorizacion getCategorizacion() {
		return this.categorizacion;
	}

	public void setCategorizacion(Categorizacion categorizacion) {
		this.categorizacion = categorizacion;
	}
	
}