package com.pids.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aprendamos.java.util.MySqlDBConn;

import com.pids.beans.Universitario;
import com.pids.interfaces.IUniversitario;

public class MySqlDUniversitario implements IUniversitario {

	@Override
	public Universitario buscarporCodigo(Integer codigo) throws SQLException {
		Universitario aux = new Universitario();
		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql = "select * from universitario where cod_univ = ?";

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		// asignamos valores a las interrogantes

		pst.setInt(1, codigo);

		// ejecutamos

		ResultSet rs1 = pst.executeQuery();

		while (rs1.next()) {
			aux.setCodUniv(rs1.getInt(1));
			aux.setNomUniv(rs1.getString(2));
			aux.setApeUniv(rs1.getString(3));
			aux.setSexoUniv(rs1.getString(4));
			aux.setFecNac(rs1.getDate(5));
			aux.setDireccion(rs1.getString(6));
			aux.setUsuario(rs1.getString(7));
			aux.setPassword(rs1.getString(8));
		}

		cn.close();

		return aux;

	}

}
