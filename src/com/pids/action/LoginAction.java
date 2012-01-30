package com.pids.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pids.beans.Menu;
import com.pids.beans.Trabajador;
import com.pids.interfaces.ITrabajador;
import com.pids.service.PaqueteBusinessDelegate;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Trabajador usuario;
	private Menu menu;
	private List<Menu> menus;
	private List<Trabajador> usuarios;

	ITrabajador serviceTrabajador = PaqueteBusinessDelegate
			.getTrabajadorService();

	public String logueo() throws Exception {
		System.out.println("ENTRO AL ACTION-LOGUEO Metodo: validaUsuario");
		System.out.println("Usuario : " + usuario.getUsuario());
		System.out.println("Password : " + usuario.getPassword());

		List<Menu> menus = null;
	

		try {
			usuario = serviceTrabajador.validaUsuario(usuario);
			System.out.println("validoUsuario?");
			menus = serviceTrabajador.traeMenus(usuario);
			System.out.println(menus.size() + "");
			this.menus = menus;
			System.out.println("listomenu?");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (usuario == null) {
			Map<String, Object> Session = ActionContext.getContext()
					.getSession();
			Session.put("MENSAJE", "Usuario no existe");
			return ERROR;
		} else {
			Map<String, Object> Session = ActionContext.getContext()
					.getSession();
			Session.put("USUARIO_LOGUEADO", usuario);
			System.out.println("Sesion : " + Session);
			Session.put("USUARIO_MENUS", menus);

		}
		return SUCCESS;

	}

	

	public Trabajador getUsuario() {
		return usuario;
	}

	public void setUsuario(Trabajador usuario) {
		this.usuario = usuario;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Trabajador> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Trabajador> usuarios) {
		this.usuarios = usuarios;
	}

}
