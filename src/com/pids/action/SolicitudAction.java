package com.pids.action;

import java.util.Date;
import java.util.List;

import com.pids.beans.CategorizacionMixto;
import com.pids.beans.Requisito;
import com.pids.beans.SolicitudAe;
import com.pids.beans.TipoSolicitud;
import com.pids.beans.Universitario;
import com.pids.interfaces.ISolicitud;
import com.pids.interfaces.IUniversitario;
import com.pids.service.PaqueteBusinessDelegate;

public class SolicitudAction {
	private List<TipoSolicitud> listaTipos;
	private List<Requisito> listaRequisitos;
	ISolicitud serviceSolicitud = PaqueteBusinessDelegate.getSolicitudService();
	IUniversitario serviceUniversitario = PaqueteBusinessDelegate
			.getUniversitario();
	private Integer tipSol;
	private Integer codUniv;
	private Universitario universitario;
	private List<CategorizacionMixto> listaCategorizacionMixta;
	private Date fecIni;
	private Date fecFin;

	public String solicitudPorFecha() {

		try {
			listaCategorizacionMixta = serviceSolicitud
					.consultarAprobadasRangoFecha(fecIni, fecFin);

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "exito";

	}

	public String ModuloRegistroSolicitud() {

		try {
			listaTipos = serviceSolicitud.listarTipos();

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "exito";
	}

	public String BuscarRequisitos() {

		try {
			listaTipos = serviceSolicitud.listarTipos();
			listaRequisitos = serviceSolicitud.listarRequisitos(tipSol);

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "exito";
	}

	public String BuscarUniversitario() {
		try {
			listaTipos = serviceSolicitud.listarTipos();

			universitario = serviceUniversitario.buscarporCodigo(codUniv);

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "exito";
	}

	public String registrarSolicitud() {
		try {
			listaTipos = serviceSolicitud.listarTipos();

			universitario = serviceUniversitario.buscarporCodigo(codUniv);
			SolicitudAe sol = new SolicitudAe();
			Universitario aux = new Universitario();
			aux.setCodUniv(codUniv);
			sol.setUniversitario(aux);
			sol.setEstado("pendiente");
			TipoSolicitud aux1 = new TipoSolicitud();
			aux1.setCodTipSol(tipSol);
			sol.setTipoSolicitud(aux1);

			serviceSolicitud.registraSolicitud(sol);

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

		return "exito";
	}

	public List<TipoSolicitud> getListaTipos() {
		return listaTipos;
	}

	public void setListaTipos(List<TipoSolicitud> listaTipos) {
		this.listaTipos = listaTipos;
	}

	public Integer getTipSol() {
		return tipSol;
	}

	public void setTipSol(Integer tipSol) {
		this.tipSol = tipSol;
	}

	public List<Requisito> getListaRequisitos() {
		return listaRequisitos;
	}

	public void setListaRequisitos(List<Requisito> listaRequisitos) {
		this.listaRequisitos = listaRequisitos;
	}

	public ISolicitud getServiceSolicitud() {
		return serviceSolicitud;
	}

	public void setServiceSolicitud(ISolicitud serviceSolicitud) {
		this.serviceSolicitud = serviceSolicitud;
	}

	public Universitario getUniversitario() {
		return universitario;
	}

	public void setUniversitario(Universitario universitario) {
		this.universitario = universitario;
	}

	public Integer getCodUniv() {
		return codUniv;
	}

	public void setCodUniv(Integer codUniv) {
		this.codUniv = codUniv;
	}

	public List<CategorizacionMixto> getListaCategorizacionMixta() {
		return listaCategorizacionMixta;
	}

	public void setListaCategorizacionMixta(
			List<CategorizacionMixto> listaCategorizacionMixta) {
		this.listaCategorizacionMixta = listaCategorizacionMixta;
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
