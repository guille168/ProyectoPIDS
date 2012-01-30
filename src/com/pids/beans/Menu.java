package com.pids.beans;

import java.io.Serializable;

import java.util.List;



public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int codMen;

	
	private String desMen;


	private String urlMen;

	//bi-directional many-to-one association to Acceso
	
	private List<Acceso> accesos;

    public Menu() {
    }

	public int getCodMen() {
		return this.codMen;
	}

	public void setCodMen(int codMen) {
		this.codMen = codMen;
	}

	public String getDesMen() {
		return this.desMen;
	}

	public void setDesMen(String desMen) {
		this.desMen = desMen;
	}

	public String getUrlMen() {
		return this.urlMen;
	}

	public void setUrlMen(String urlMen) {
		this.urlMen = urlMen;
	}

	public List<Acceso> getAccesos() {
		return this.accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}
	
}