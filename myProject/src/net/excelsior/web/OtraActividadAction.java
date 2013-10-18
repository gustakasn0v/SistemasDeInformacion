package net.excelsior.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.excelsior.dao.OtraActividadDAO;
import net.excelsior.dao.OtraActividadDAOImpl;
import net.excelsior.domain.OtraActividad;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OtraActividadAction extends ActionSupport implements ModelDriven<OtraActividad> {

	private static final long serialVersionUID = -6659925652584240539L;

	private OtraActividad otraActividad = new OtraActividad();
	private List<OtraActividad> otraActividadList = new ArrayList<OtraActividad>();
	private OtraActividadDAO otraActividadDAO = new OtraActividadDAOImpl();
	
	
	public OtraActividad getModel() {
		return otraActividad;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		otraActividadList = otraActividadDAO.listOtraActividad(username);
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	
	public OtraActividad getOtraActividad() {
		return otraActividad;
	}

	public void setOtraActividad(OtraActividad OtraActividad) {
		this.otraActividad = OtraActividad;
	}

	public List<OtraActividad> getOtraActividadList() {
		return otraActividadList;
	}

	public void setOtraActividadList(List<OtraActividad> OtraActividadList) {
		this.otraActividadList = OtraActividadList;
	}

}