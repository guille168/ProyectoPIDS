package com.pids.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the universitario database table.
 * 
 */

public class Universitario implements Serializable {
	private static final long serialVersionUID = 1L;


	private int codUniv;


	private String apeUniv;

	private String direccion;

   
	private Date fecNac;

	private String nomUniv;

	private String password;


	private String sexoUniv;

	private int telefono;

	private String usuario;

	
	private List<Acceso> accesos;

	private List<SolicitudAe> solicitudAes;

    public Universitario() {
    }

	public int getCodUniv() {
		return this.codUniv;
	}

	public void setCodUniv(int codUniv) {
		this.codUniv = codUniv;
	}

	public String getApeUniv() {
		return this.apeUniv;
	}

	public void setApeUniv(String apeUniv) {
		this.apeUniv = apeUniv;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecNac() {
		return this.fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public String getNomUniv() {
		return this.nomUniv;
	}

	public void setNomUniv(String nomUniv) {
		this.nomUniv = nomUniv;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexoUniv() {
		return this.sexoUniv;
	}

	public void setSexoUniv(String sexoUniv) {
		this.sexoUniv = sexoUniv;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Acceso> getAccesos() {
		return this.accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}
	
	public List<SolicitudAe> getSolicitudAes() {
		return this.solicitudAes;
	}

	public void setSolicitudAes(List<SolicitudAe> solicitudAes) {
		this.solicitudAes = solicitudAes;
	}
	
}