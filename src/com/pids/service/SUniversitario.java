package com.pids.service;

import java.sql.SQLException;

import com.pids.beans.Universitario;
import com.pids.dao.DAOFactory;
import com.pids.interfaces.IUniversitario;

public class SUniversitario implements IUniversitario {


	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	IUniversitario objUniversitario = fabrica.getUniversitario();
	
	@Override
	public Universitario buscarporCodigo(Integer codigo) throws SQLException {
		// TODO Auto-generated method stub
		return objUniversitario.buscarporCodigo(codigo);
	}

}
