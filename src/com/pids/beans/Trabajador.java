package com.pids.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class Trabajador implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int codTra;

	private String apeTra;

	private String direccion;

	private Date fecNac;

	
	private String nomTra;

	private String password;


	private String sexoTra;

	private int telefono;


	private String tipoTra;

	private String usuario;

	private List<Acceso> accesos;

	private List<SolicitudAe> solicitudAes;

    public Trabajador() {
    }

	public int getCodTra() {
		return this.codTra;
	}

	public void setCodTra(int codTra) {
		this.codTra = codTra;
	}

	public String getApeTra() {
		return this.apeTra;
	}

	public void setApeTra(String apeTra) {
		this.apeTra = apeTra;
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

	public String getNomTra() {
		return this.nomTra;
	}

	public void setNomTra(String nomTra) {
		this.nomTra = nomTra;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexoTra() {
		return this.sexoTra;
	}

	public void setSexoTra(String sexoTra) {
		this.sexoTra = sexoTra;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getTipoTra() {
		return this.tipoTra;
	}

	public void setTipoTra(String tipoTra) {
		this.tipoTra = tipoTra;
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