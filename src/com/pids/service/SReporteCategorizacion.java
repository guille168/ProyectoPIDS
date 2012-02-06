package com.pids.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pids.beans.Categorizacion;
import com.pids.beans.CategorizacionMixto;
import com.pids.beans.ReporteCategorizacionMixto;
import com.pids.beans.SolicitudAe;
import com.pids.dao.DAOFactory;
import com.pids.interfaces.ICategorizacion;
import com.pids.interfaces.IReporteCategorizacion;

public class SReporteCategorizacion implements IReporteCategorizacion {

	DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	IReporteCategorizacion objCategorizacion = fabrica.getReporteCategorizacion();

	

	@Override
	public List<ReporteCategorizacionMixto> consultaRangoFecha(Date fecini,
			Date fecfin, String estado) throws SQLException {
		// TODO Auto-generated method stub
		return objCategorizacion.consultaRangoFecha(fecini, fecfin,estado);
	}

}
