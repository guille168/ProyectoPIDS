package com.pids.beans;

import java.io.Serializable;


/**
 * The persistent class for the acceso database table.
 * 
 */

public class Acceso implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int codMen;


	private int codTra;


	private int codUniv;


	//bi-directional many-to-one association to Menu
    
	

	private Menu menu;

	//bi-directional many-to-one association to Universitario
   
	private Universitario universitario;

	//bi-directional many-to-one association to Trabajador
  
	private Trabajador trabajador;

    public Acceso() {
    }

	
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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
	public int getCodMen() {
		return codMen;
	}

	public void setCodMen(int codMen) {
		this.codMen = codMen;
	}

	public int getCodTra() {
		return codTra;
	}

	public void setCodTra(int codTra) {
		this.codTra = codTra;
	}

	public int getCodUniv() {
		return codUniv;
	}

	public void setCodUniv(int codUniv) {
		this.codUniv = codUniv;
	}
	
}