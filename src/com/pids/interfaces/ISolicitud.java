package com.pids.interfaces;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.pids.beans.CategorizacionMixto;
import com.pids.beans.DetalleSolicitud;
import com.pids.beans.Requisito;
import com.pids.beans.SolicitudAe;
import com.pids.beans.TipoSolicitud;

public interface ISolicitud {
	public abstract List<DetalleSolicitud> detalleSolicitud(SolicitudAe sol) throws SQLException;
	public abstract List<SolicitudAe> listaSolicitud(Integer sol) throws SQLException;
	public abstract List<SolicitudAe> listaTodas() throws SQLException;
	public abstract List<TipoSolicitud> listarTipos() throws SQLException;
	public List<Requisito> listarRequisitos(Integer tipSol) throws SQLException;
	public int registraSolicitud(SolicitudAe sol) throws SQLException;
	public abstract List<CategorizacionMixto> consultarAprobadasRangoFecha(Date fecIni, Date fecFin) throws SQLException ;
}
