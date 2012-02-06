package com.pids.dao;

import com.pids.interfaces.ICategorizacion;
import com.pids.interfaces.IReporteCategorizacion;
import com.pids.interfaces.ISolicitud;
import com.pids.interfaces.ITrabajador;
import com.pids.interfaces.IUniversitario;

public class MySqlDAOFactory extends DAOFactory {

//	@Override
//	public ClienteDAO getClienteDAO() {
//		// TODO Auto-generated method stub
//		return new MySqlClienteDAO();
//	}

	@Override
	public ICategorizacion getCategorizacion() {
		// TODO Auto-generated method stub
		return new MySqlDCategorizacion();
	}

	@Override
	public ISolicitud getSolicitud() {
		// TODO Auto-generated method stub
		return new MySqlDSolicitud();
	}

	@Override
	public IUniversitario getUniversitario() {
		// TODO Auto-generated method stub
		return new MySqlDUniversitario();
	}

	@Override
	public ITrabajador getTrabajador() {
		// TODO Auto-generated method stub
		return new MySqlDTrabajador();
	}

	@Override
	public IReporteCategorizacion getReporteCategorizacion() {
		// TODO Auto-generated method stub
		return new MySqlDReporteCategorizacion();
	}
	
// Esta es una fabrica que crea DAOs especificos para  Mysql 
	
	
	

	

}
