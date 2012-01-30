package com.pids.service;

import java.sql.SQLException;
import java.util.List;

import com.pids.beans.Menu;
import com.pids.beans.Trabajador;
import com.pids.dao.DAOFactory;
import com.pids.interfaces.ITrabajador;

public class STrabajador implements ITrabajador {


	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	ITrabajador objtTrabajador = fabrica.getTrabajador();
	


	@Override
	public List<Menu> traeMenus(Trabajador usuario) throws SQLException {
		// TODO Auto-generated method stub
		return objtTrabajador.traeMenus(usuario);
	}

	@Override
	public Trabajador validaUsuario(Trabajador usuario) throws SQLException {
		// TODO Auto-generated method stub
		return objtTrabajador.validaUsuario(usuario);
	}

}
