package com.pids.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aprendamos.java.util.MySqlDBConn;

import com.pids.beans.Menu;
import com.pids.beans.Trabajador;
import com.pids.interfaces.ITrabajador;

public class MySqlDTrabajador implements ITrabajador {

	@Override
	public List<Menu> traeMenus(Trabajador usuario) throws SQLException {
		ArrayList<Menu> lista = new ArrayList<Menu>();

		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql = "Select cod_men,des_men,url_men from menu where cod_men in ( select cod_men from acceso where cod_tra = ?)";

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		// asignamos valores a las interrogantes
		pst.setInt(1, usuario.getCodTra());
		// ejecutamos

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			Menu objCategorizacion = new Menu();
			objCategorizacion.setCodMen(rs.getInt(1));
			objCategorizacion.setDesMen(rs.getString(2));
			objCategorizacion.setUrlMen(rs.getString(3));
			lista.add(objCategorizacion);

		}

		cn.close();

		return lista;
	}

	@Override
	public Trabajador validaUsuario(Trabajador usuario) throws SQLException {
		Trabajador lista = null;

		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql = "Select cod_tra,nom_tra,ape_tra from trabajador where usuario = ? and password = ?";

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		// asignamos valores a las interrogantes
		pst.setString(1, usuario.getUsuario());
		pst.setString(2, usuario.getPassword());
		// ejecutamos

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			lista = new Trabajador();
			lista.setCodTra(rs.getInt(1));
			lista.setNomTra(rs.getString(2));
			lista.setApeTra(rs.getString(3));
			lista.setUsuario(usuario.getUsuario());
			lista.setPassword(usuario.getPassword());

		}

		cn.close();

		return lista;
	}
}
