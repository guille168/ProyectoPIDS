package com.pids.action;

import java.sql.Date;
import java.util.List;

import com.pids.beans.Categorizacion;
import com.pids.beans.CategorizacionMixto;
import com.pids.beans.SolicitudAe;
import com.pids.interfaces.ICategorizacion;
import com.pids.interfaces.ISolicitud;
import com.pids.service.PaqueteBusinessDelegate;

public class CategorizacionAction {

	private SolicitudAe solicitud;
	private int numSolicitud;
	private List<Categorizacion> listaCategorizacion;
	private List<SolicitudAe> listaSolicitud;
	private Categorizacion categorizacionB;
	private List<CategorizacionMixto> listaCategorizacionMixta;
	private Date fecIni;
	private Date fecFin;
	private String estadoCate;
	ICategorizacion serviceCategorizacion = PaqueteBusinessDelegate
			.getCategorizacionService();
	ISolicitud serviceSolicitud = PaqueteBusinessDelegate.getSolicitudService();

	public String filtrarPorSolicitud() {
		try {

			listaSolicitud = serviceCategorizacion
					.filtrarPorCategorizacion(numSolicitud);

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "exito";
	}

	public String filtrarSolicitud() {
		try {

			listaSolicitud = serviceSolicitud.listaSolicitud(numSolicitud);
			for (SolicitudAe aux : listaSolicitud) {
				solicitud = aux;

			}
			System.out.println(listaSolicitud.size());

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "exito";

	}

	public String categorizacionPorFecha() {
		try {
			
			System.out.println("FecIni : "+ fecIni);
			System.out.println("FecFin : "+ fecFin);
			
			listaCategorizacionMixta = serviceCategorizacion
					.consultaRangoFecha(fecIni, fecFin,
							estadoCate);

			System.out.println(listaCategorizacionMixta.size());

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "exito";

	}

	public String generarCategorizacion() {
		try {

			listaSolicitud = serviceSolicitud.listaTodas();

			System.out.println(listaSolicitud.size());

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "exito";

	}

	public String registraCategorizacion() {
		try {
			solicitud = new SolicitudAe();
			solicitud.setNumSolicitud(numSolicitud);
			categorizacionB.setSolicitudAe(solicitud);

			if (categorizacionB.getDescripcion().equals("RECHAZADO"))
				categorizacionB.setMontoEntrega(0.0);

			int i = serviceCategorizacion
					.registraCategorizacion(categorizacionB);
			if (i > 0)
				return "exito";
			else
				return "error";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "exito";
	}

	public List<Categorizacion> getListaCategorizacion() {
		return listaCategorizacion;
	}

	public void setListaCategorizacion(List<Categorizacion> listaCategorizacion) {
		this.listaCategorizacion = listaCategorizacion;
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

	public List<CategorizacionMixto> getListaCategorizacionMixta() {
		return listaCategorizacionMixta;
	}

	public void setListaCategorizacionMixta(
			List<CategorizacionMixto> listaCategorizacionMixta) {
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
