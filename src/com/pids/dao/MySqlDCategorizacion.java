package com.pids.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aprendamos.java.util.MySqlDBConn;

import com.pids.beans.Categorizacion;
import com.pids.beans.CategorizacionMixto;
import com.pids.beans.SolicitudAe;
import com.pids.interfaces.ICategorizacion;

public class MySqlDCategorizacion implements ICategorizacion {

	@Override
	public List<SolicitudAe> filtrarPorCategorizacion(Integer sol)
			throws SQLException {

		ArrayList<SolicitudAe> lista = new ArrayList<SolicitudAe>();

		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql = "select num_solicitud,estado from solicitud_ae where num_solicitud in (select num_solicitud from categorizacion where cod_cate=?)";

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		// asignamos valores a las interrogantes
		pst.setInt(1, sol);

		// ejecutamos

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			SolicitudAe objCategorizacion = new SolicitudAe();
			objCategorizacion.setNumSolicitud(rs.getInt(1));
			objCategorizacion.setEstado(rs.getString(2));
			lista.add(objCategorizacion);

		}

		cn.close();

		return lista;
	}

	@Override
	public int registraCategorizacion(Categorizacion sol) throws SQLException {
		int resultado = 0;

		Connection cn = MySqlDBConn.obtenerConexion();

		String sql = "insert into categorizacion(cod_cate,num_solicitud,monto_entrega,descripcion,estado)"
				+ "" + "values (null,?,?,?,?)";

		PreparedStatement pst = cn.prepareStatement(sql);

		// asignamos valores a las interrogantes
		pst.setInt(1, sol.getSolicitudAe().getNumSolicitud());
		pst.setDouble(2, sol.getMontoEntrega());
		pst.setString(3, sol.getDescripcion());
		pst.setString(4, sol.getEstado());

		// ejecutamos la sentencia
		resultado = pst.executeUpdate();

		cn.close();

		return resultado;

	}

	@Override
	public List<CategorizacionMixto> consultaRangoFecha(Date fecini,
			Date fecfin, String estado) throws SQLException {
		ArrayList<CategorizacionMixto> lista = new ArrayList<CategorizacionMixto>();

		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql = "SELECT u.nom_univ, u.ape_univ,s.num_solicitud,ts.descripcion,c.monto_entrega,t.nom_tra "
				+ "FROM categorizacion c INNER JOIN solicitud_ae s on c.num_solicitud = s.num_solicitud "
				+ "INNER JOIN universitario u on s.cod_univ = u.cod_univ INNER JOIN trabajador t on s.cod_tra = t.cod_tra "
				+ "INNER JOIN tipo_solicitud ts on s.cod_tip_sol = ts.cod_tip_sol "
				+ "WHERE c.estado = ? and (s.fecha between ? and ?) ";

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setString(1, estado);
		pst.setDate(2, (java.sql.Date) fecini);
		pst.setDate(3, (java.sql.Date) fecfin);
		// asignamos valores a las interrogantes
		// pst.setInt(1, sol);

		// ejecutamos

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			CategorizacionMixto obj = new CategorizacionMixto();
			obj.setNom_univ(rs.getString(1));
			obj.setApe_univ(rs.getString(2));
			obj.setNum_solicitud(rs.getString(3));
			obj.setTipo_solicitud(rs.getString(4));
			obj.setMonto_entrega(rs.getDouble(5));
			obj.setNom_tra(rs.getString(6));
			lista.add(obj);

		}

		cn.close();

		return lista;
	}
}
