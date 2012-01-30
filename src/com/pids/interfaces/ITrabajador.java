package com.pids.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.pids.beans.Menu;
import com.pids.beans.Trabajador;

public interface ITrabajador {
	public abstract List<Menu> traeMenus(Trabajador usuario)
			throws SQLException;
	public abstract Trabajador  validaUsuario(Trabajador usuario)
	throws SQLException;
}
