package net.excelsior.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.excelsior.dao.MateriaModificadaDAO;
import net.excelsior.dao.MateriaModificadaDAOImpl;
import net.excelsior.domain.MateriaModificada;

import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.Valid;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MateriaModificadaAction extends ActionSupport implements ModelDriven<MateriaModificada> {

	private static final long serialVersionUID = -6659925652584240539L;

	@Valid
	private MateriaModificada materiaModificada = new MateriaModificada();
	private List<MateriaModificada> materiaModificadaList = new ArrayList<MateriaModificada>();
	private MateriaModificadaDAO materiaModificadaDAO = new MateriaModificadaDAOImpl();
	
	
	public MateriaModificada getModel() {
		return materiaModificada;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		materiaModificadaDAO.saveOrUpdateMateriaModificada(materiaModificada,username);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		materiaModificadaList = materiaModificadaDAO.listMateriaModificada(username);
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String delete()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		materiaModificadaDAO.deleteMateriaModificada(Long.parseLong(request.getParameter("id")),username);
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String edit()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		materiaModificada = materiaModificadaDAO.listMateriaModificadaById(Long.parseLong(request.getParameter("id")));
		materiaModificadaDAO.deleteMateriaModificada(Long.parseLong(request.getParameter("id")),username);
		return SUCCESS;
	}

	public String Mod()
	{
		return SUCCESS;
	}
	
	public MateriaModificada getMateriaModificada() {
		return materiaModificada;
	}

	public void setMateriaModificada(MateriaModificada materiaModificada) {
		this.materiaModificada = materiaModificada;
	}

	public List<MateriaModificada> getMateriaModificadaList() {
		return materiaModificadaList;
	}

	public void setMateriaModificadaList(List<MateriaModificada> materiaModificadaList) {
		this.materiaModificadaList = materiaModificadaList;
	}

}