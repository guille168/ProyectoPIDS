package com.pids.interfaces;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pids.beans.Categorizacion;
import com.pids.beans.CategorizacionMixto;
import com.pids.beans.SolicitudAe;

public interface ICategorizacion {

	public List<SolicitudAe> filtrarPorCategorizacion(Integer sol)
	throws SQLException;
	public abstract int registraCategorizacion(Categorizacion sol) throws SQLException;
	public List<CategorizacionMixto> consultaRangoFecha(Date fecini, Date fecfin, String estado)
	throws SQLException;
}
