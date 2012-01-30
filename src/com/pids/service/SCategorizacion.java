package com.pids.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pids.beans.Categorizacion;
import com.pids.beans.CategorizacionMixto;
import com.pids.beans.SolicitudAe;
import com.pids.dao.DAOFactory;
import com.pids.interfaces.ICategorizacion;

public class SCategorizacion implements ICategorizacion {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	ICategorizacion objCategorizacion = fabrica.getCategorizacion();

	@Override
	public List<SolicitudAe> filtrarPorCategorizacion(Integer sol)
	throws SQLException {
		// TODO Auto-generated method stub
		return objCategorizacion.filtrarPorCategorizacion(sol);
	}

	@Override
	public int registraCategorizacion(Categorizacion sol) throws SQLException {
		
		return objCategorizacion.registraCategorizacion(sol);
	}

	@Override
	public List<CategorizacionMixto> consultaRangoFecha(Date fecini,
			Date fecfin, String estado) throws SQLException {
		// TODO Auto-generated method stub
		return objCategorizacion.consultaRangoFecha(fecini, fecfin,estado);
	}

}
