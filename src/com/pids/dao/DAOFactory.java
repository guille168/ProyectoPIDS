/*
 * Created on 01/10/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.pids.dao;

import com.pids.interfaces.ICategorizacion;
import com.pids.interfaces.ISolicitud;
import com.pids.interfaces.ITrabajador;
import com.pids.interfaces.IUniversitario;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;

	public static final int JPA = 6;

	// Existir� un m�todo por cada DAO que pueda ser creado.
	// Ejemplo:
	// public abstract ArticuloDAO getArticuloDAO();

	// registramos nuestros daos
	// public abstract ProductoDAO getProductoDAO();
	public abstract ICategorizacion getCategorizacion();
	public abstract ISolicitud getSolicitud();
	public abstract IUniversitario getUniversitario();
	public abstract ITrabajador getTrabajador();

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:
			return new MySqlDAOFactory();
			// case XML:
			// return new XmlDAOFactory();
			// case ORACLE:
			// return new OracleDAOFactory();
			// case JPA:
			// return new JpaDAOFactory();
			/*
			 * case DB2: return new Db2DAOFactory(); case SQLSERVER: return new
			 * SqlServerDAOFactory(); case XML: return new XmlDAOFactory();
			 */
		default:
			return null;
		}
	}

}
