package com.pids.interfaces;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pids.beans.ReporteCategorizacionMixto;


public interface IReporteCategorizacion {

	public List<ReporteCategorizacionMixto> consultaRangoFecha(Date fecini, Date fecfin, String estado)
	throws SQLException;
}
