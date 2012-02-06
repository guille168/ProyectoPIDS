package com.pids.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aprendamos.java.util.MySqlDBConn;

import com.pids.beans.CategorizacionMixto;
import com.pids.beans.DetalleSolicitud;
import com.pids.beans.Requisito;
import com.pids.beans.SolicitudAe;
import com.pids.beans.TipoSolicitud;
import com.pids.beans.Universitario;
import com.pids.interfaces.ISolicitud;

public class MySqlDSolicitud implements ISolicitud {

	@Override
	public List<DetalleSolicitud> detalleSolicitud(SolicitudAe sol)
			throws SQLException {

		ArrayList<DetalleSolicitud> lista = new ArrayList<DetalleSolicitud>();
		ArrayList<Requisito> requisitos = new ArrayList<Requisito>();
		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql1 = "select * from requisito";
		PreparedStatement pst1 = cn.prepareStatement(sql1);
		// asignamos valores a las interrogantes
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {

			Requisito requisito = new Requisito();
			requisito.setCodReqAnx(rs1.getInt(1));
			requisito.setDescripcion(rs1.getString(2));
			requisito.setTipo(rs1.getString(3));
			requisitos.add(requisito);
		}

		String sql = "select * from detalle_solicitud where num_solicitud = ?";

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		// asignamos valores a las interrogantes
		System.out.println(sol.getNumSolicitud());
		pst.setInt(1, sol.getNumSolicitud());

		// ejecutamos

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			DetalleSolicitud objDetalleSolicitud = new DetalleSolicitud();
			objDetalleSolicitud.setIdDetalle_Solicitud(rs.getInt(1));
			for (SolicitudAe aux2 : listaSolicitud(rs.getInt(2))) {
				if (rs.getInt(2) == aux2.getNumSolicitud())
					objDetalleSolicitud.setSolicitudAe(aux2);

			}

			for (Requisito aux : requisitos) {
				if (rs.getInt(3) == aux.getCodReqAnx()) {
					objDetalleSolicitud.setRequisito(aux);
				}
			}

			objDetalleSolicitud.setImagen(rs.getString(4));
			lista.add(objDetalleSolicitud);
		}

		cn.close();

		return lista;
	}

	@Override///cambios para filtara solocitudes pendienes
	public List<SolicitudAe> listaSolicitud(Integer sol) throws SQLException {
		ArrayList<SolicitudAe> lista = new ArrayList<SolicitudAe>();
		ArrayList<Universitario> universitarios = new ArrayList<Universitario>();
		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql1 = "select * from universitario";
		PreparedStatement pst1 = cn.prepareStatement(sql1);
		// asignamos valores a las interrogantes
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {

			Universitario requisito = new Universitario();
			requisito.setCodUniv(rs1.getInt(1));
			requisito.setNomUniv(rs1.getString(2));
			requisito.setApeUniv(rs1.getString(3));
			requisito.setSexoUniv(rs1.getString(4));
			requisito.setFecNac(rs1.getDate(5));
			requisito.setDireccion(rs1.getString(6));
			requisito.setUsuario(rs1.getString(7));
			requisito.setPassword(rs1.getString(8));
			universitarios.add(requisito);
		}

		String sql = "select * from solicitud_ae where num_solicitud = ?";

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		// asignamos valores a las interrogantes
		pst.setInt(1, sol);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			SolicitudAe objSolicitudAe = new SolicitudAe();

			objSolicitudAe.setNumSolicitud(rs.getInt(1));
			objSolicitudAe.setFecha(rs.getDate(2));
			for (Universitario aux : universitarios) {
				if (rs.getInt(4) == aux.getCodUniv())
					objSolicitudAe.setUniversitario(aux);
			}
			objSolicitudAe.setEstado(rs.getString(5));
			lista.add(objSolicitudAe);
		}

		cn.close();

		return lista;
	}

	public List<SolicitudAe> listaTodas() throws SQLException {
		ArrayList<SolicitudAe> lista = new ArrayList<SolicitudAe>();
		ArrayList<Universitario> universitarios = new ArrayList<Universitario>();
		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql1 = "select * from universitario";
		PreparedStatement pst1 = cn.prepareStatement(sql1);
		// asignamos valores a las interrogantes
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {

			Universitario requisito = new Universitario();
			requisito.setCodUniv(rs1.getInt(1));
			requisito.setNomUniv(rs1.getString(2));
			requisito.setApeUniv(rs1.getString(3));
			requisito.setSexoUniv(rs1.getString(4));
			requisito.setFecNac(rs1.getDate(5));
			requisito.setDireccion(rs1.getString(6));
			requisito.setUsuario(rs1.getString(7));
			requisito.setPassword(rs1.getString(8));
			universitarios.add(requisito);
		}

		String sql = "select * from solicitud_ae";

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		// asignamos valores a las interrogantes

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			SolicitudAe objSolicitudAe = new SolicitudAe();

			objSolicitudAe.setNumSolicitud(rs.getInt(1));
			objSolicitudAe.setFecha(rs.getDate(2));
			for (Universitario aux : universitarios) {
				if (rs.getInt(4) == aux.getCodUniv())
					objSolicitudAe.setUniversitario(aux);
			}
			objSolicitudAe.setEstado(rs.getString(5));
			lista.add(objSolicitudAe);
		}

		cn.close();

		return lista;
	}

	@Override
	public List<TipoSolicitud> listarTipos() throws SQLException {
		ArrayList<TipoSolicitud> lista = new ArrayList<TipoSolicitud>();

		Connection cn = MySqlDBConn.obtenerConexion();

		String sql1 = "select * from tipo_solicitud";
		PreparedStatement pst1 = cn.prepareStatement(sql1);
		// asignamos valores a las interrogantes
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {

			TipoSolicitud requisito = new TipoSolicitud();
			requisito.setCodTipSol(rs1.getInt(1));
			requisito.setDescripcion(rs1.getString(2));

			lista.add(requisito);
		}

		cn.close();

		return lista;
	}

	public List<Requisito> listarRequisitos(Integer tipSol) throws SQLException {

		ArrayList<Requisito> requisitos = new ArrayList<Requisito>();
		Connection cn = MySqlDBConn.obtenerConexion();
		String sql = "select * from requisito where cod_req_anx in(select cod_req_anx from detalle_tipo_anexo where cod_tip_sol = ?)";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setInt(1, tipSol);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {

			Requisito requisito = new Requisito();
			requisito.setCodReqAnx(rs.getInt(1));
			requisito.setDescripcion(rs.getString(2));

			requisitos.add(requisito);
		}
		return requisitos;

	}

	@Override
	public int registraSolicitud(SolicitudAe sol) throws SQLException {
		int resultado = 0;
		
		java.util.Date date = new java.util.Date(); 
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
		String fecha = sdf.format(date);
		
		Connection cn = MySqlDBConn.obtenerConexion();
/*
		String sql = "insert into solicitud_ae(num_solicitud,,fecha,cod_tip_sol,cod_univ,estado,cod_tra)"
				+ "" + "values (null,,?,?,?,1)";*/
		String sql = "insert into solicitud_ae(num_solicitud,fecha,cod_tip_sol,cod_univ,estado,cod_tra)"
			+ "" + "values (null,?,?,?,?,1)";

		PreparedStatement pst = cn.prepareStatement(sql);

		// asignamos valores a las interrogantes
		pst.setString(1, fecha);
		pst.setInt(2, sol.getTipoSolicitud().getCodTipSol());
		pst.setDouble(3, sol.getUniversitario().getCodUniv());
		pst.setString(4, sol.getEstado());

		// ejecutamos la sentencia
		resultado = pst.executeUpdate();

		cn.close();

		return resultado;

	}

	@Override
	public List<CategorizacionMixto> consultarAprobadasRangoFecha(Date fecIni,
			Date fecFin) throws SQLException {
		ArrayList<CategorizacionMixto> lista = new ArrayList<CategorizacionMixto>();

		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql = "SELECT u.nom_univ, u.ape_univ,s.num_solicitud,ts.descripcion,t.nom_tra "
				+ "FROM  solicitud_ae s "
				+ "INNER JOIN universitario u on s.cod_univ = u.cod_univ INNER JOIN trabajador t on s.cod_tra = t.cod_tra "
				+ "INNER JOIN tipo_solicitud ts on s.cod_tip_sol = ts.cod_tip_sol " 
				+ "WHERE (s.estado = ?) and (s.fecha between ?  and ?) ";

		// la preparamos
		String estado = "APROBADO";
		PreparedStatement pst = cn.prepareStatement(sql);
		pst.setString(1, estado);
		pst.setDate(2,(java.sql.Date) fecIni);
		pst.setDate(3, (java.sql.Date) fecFin);
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
			obj.setNom_tra(rs.getString(5));
			lista.add(obj);

		}

		cn.close();

		return lista;
	}

	@Override
	public List<SolicitudAe> listaSolicitudPendientes(Integer sol)throws SQLException {
		
		ArrayList<SolicitudAe> lista = new ArrayList<SolicitudAe>();
		ArrayList<Universitario> universitarios = new ArrayList<Universitario>();
		Connection cn = MySqlDBConn.obtenerConexion();

		// definimos la sentencia
		String sql1 = "select * from universitario ";
		PreparedStatement pst1 = cn.prepareStatement(sql1);
		// asignamos valores a las interrogantes
		ResultSet rs1 = pst1.executeQuery();
		while (rs1.next()) {

			Universitario requisito = new Universitario();
			requisito.setCodUniv(rs1.getInt(1));
			requisito.setNomUniv(rs1.getString(2));
			requisito.setApeUniv(rs1.getString(3));
			requisito.setSexoUniv(rs1.getString(4));
			requisito.setFecNac(rs1.getDate(5));
			requisito.setDireccion(rs1.getString(6));
			requisito.setUsuario(rs1.getString(7));
			requisito.setPassword(rs1.getString(8));
			universitarios.add(requisito);
		}
		String estado= "pendiente";
		String sql = "select * from solicitud_ae where num_solicitud = ? and estado = ?" ;
		System.out.println("cadena filtro: " + sql);

		// la preparamos
		PreparedStatement pst = cn.prepareStatement(sql);
		// asignamos valores a las interrogantes
		pst.setInt(1, sol);
		pst.setString(2, estado);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {

			SolicitudAe objSolicitudAe = new SolicitudAe();

			objSolicitudAe.setNumSolicitud(rs.getInt(1));
			objSolicitudAe.setFecha(rs.getDate(2));
			for (Universitario aux : universitarios) {
				if (rs.getInt(4) == aux.getCodUniv())
					objSolicitudAe.setUniversitario(aux);
			}
			objSolicitudAe.setEstado(rs.getString(5));
			lista.add(objSolicitudAe);
		}

		cn.close();

		return lista;
	}

}
