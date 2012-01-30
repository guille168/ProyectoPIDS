package com.pids.interfaces;

import java.sql.SQLException;

import com.pids.beans.Universitario;

public interface IUniversitario {

	
	public abstract Universitario buscarporCodigo(Integer codigo) throws SQLException;
	
}
