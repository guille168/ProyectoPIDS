package com.pids.action;

import java.sql.Date;
import java.util.List;

import com.pids.beans.Categorizacion;
import com.pids.beans.CategorizacionMixto;
import com.pids.beans.ReporteCategorizacionMixto;
import com.pids.beans.SolicitudAe;
import com.pids.interfaces.ICategorizacion;
import com.pids.interfaces.IReporteCategorizacion;
import com.pids.interfaces.ISolicitud;
import com.pids.service.PaqueteBusinessDelegate;

public class ReporteCategorizacionAction {

	private SolicitudAe solicitud;
	private int numSolicitud;
	private List<SolicitudAe> listaSolicitud;
	private Categorizacion categorizacionB;
	private List<ReporteCategorizacionMixto> listaCategorizacionMixta;
	private Date fecIni;
	private Date fecFin;
	private String estadoCate;
	IReporteCategorizacion serviceCategorizacion = PaqueteBusinessDelegate
			.getReporteCategorizacion();
	ISolicitud serviceSolicitud = PaqueteBusinessDelegate.getSolicitudService();



	

	public String categorizacionPorFecha() {
		try {
			
			System.out.println("FecIni : "+ fecIni);
			System.out.println("FecFin : "+ fecFin);
			
			listaCategorizacionMixta = serviceCategorizacion.consultaRangoFecha(fecIni, fecFin,
							estadoCate);

			System.out.println(listaCategorizacionMixta.size());

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "exito";

	}

	

	public SolicitudAe getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudAe solicitud) {
		this.solicitud = solicitud;
	}

	public int getNumSolicitud() {
		return numSolicitud;
	}

	public void setNumSolicitud(int numSolicitud) {
		this.numSolicitud = numSolicitud;
	}

	public Categorizacion getCategorizacionB() {
		return categorizacionB;
	}

	public void setCategorizacionB(Categorizacion categorizacionB) {
		this.categorizacionB = categorizacionB;
	}

	public List<SolicitudAe> getListaSolicitud() {
		return listaSolicitud;
	}

	public void setListaSolicitud(List<SolicitudAe> listaSolicitud) {
		this.listaSolicitud = listaSolicitud;
	}



	public List<ReporteCategorizacionMixto> getListaCategorizacionMixta() {
		return listaCategorizacionMixta;
	}



	public void setListaCategorizacionMixta(
			List<ReporteCategorizacionMixto> listaCategorizacionMixta) {
		this.listaCategorizacionMixta = listaCategorizacionMixta;
	}



	public String getEstadoCate() {
		return estadoCate;
	}

	public void setEstadoCate(String estadoCate) {
		this.estadoCate = estadoCate;
	}

	public Date getFecIni() {
		return fecIni;
	}

	public void setFecIni(Date fecIni) {
		this.fecIni = fecIni;
	}

	public Date getFecFin() {
		return fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

}
