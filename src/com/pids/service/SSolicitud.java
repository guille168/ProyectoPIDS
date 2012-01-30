package com.pids.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pids.beans.CategorizacionMixto;
import com.pids.beans.DetalleSolicitud;
import com.pids.beans.Requisito;
import com.pids.beans.SolicitudAe;
import com.pids.beans.TipoSolicitud;
import com.pids.dao.DAOFactory;
import com.pids.interfaces.ISolicitud;

public class SSolicitud implements ISolicitud {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	ISolicitud objSolicitud = fabrica.getSolicitud();

	
	@Override
	public List<DetalleSolicitud> detalleSolicitud(SolicitudAe sol)
			throws SQLException {
		// TODO Auto-generated method stub
		return objSolicitud.detalleSolicitud(sol);
	}


	@Override
	public List<SolicitudAe> listaSolicitud(Integer sol) throws SQLException {
		// TODO Auto-generated method stub
		return objSolicitud.listaSolicitud(sol);
	}


	@Override
	public List<SolicitudAe> listaTodas() throws SQLException {
		// TODO Auto-generated method stub
		return objSolicitud.listaTodas();
	}


	@Override
	public List<TipoSolicitud> listarTipos() throws SQLException {
		// TODO Auto-generated method stub
		return objSolicitud.listarTipos();
	}


	@Override
	public List<Requisito> listarRequisitos(Integer tipSol) throws SQLException {
		// TODO Auto-generated method stub
		return objSolicitud.listarRequisitos(tipSol);
	}


	@Override
	public int registraSolicitud(SolicitudAe sol) throws SQLException {
		// TODO Auto-generated method stub
		return objSolicitud.registraSolicitud(sol);
	}


	@Override
	public List<CategorizacionMixto> consultarAprobadasRangoFecha(Date fecIni,
			Date fecFin) throws SQLException {
		// TODO Auto-generated method stub
		return objSolicitud.consultarAprobadasRangoFecha(fecIni, fecFin);
	}

}
