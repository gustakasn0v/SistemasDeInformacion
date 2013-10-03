package net.excelsior.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.excelsior.dao.MateriaDAO;
import net.excelsior.dao.MateriaDAOImpl;
import net.excelsior.domain.Materia;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MateriaAction extends ActionSupport implements ModelDriven<Materia> {

	private static final long serialVersionUID = -6659925652584240539L;

	private Materia materia = new Materia();
	private List<Materia> materiaList = new ArrayList<Materia>();
	private MateriaDAO materiaDAO = new MateriaDAOImpl();
	
	
	public Materia getModel() {
		return materia;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		materiaDAO.saveOrUpdateMateria(materia,username);
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
		
		materiaList = materiaDAO.listMateria(username);
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		System.out.println(request.getParameter("id"));
		materiaDAO.deleteMateria(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		materia = materiaDAO.listMateriaById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public List<Materia> getMateriaList() {
		return materiaList;
	}

	public void setMateriaList(List<Materia> materiaList) {
		this.materiaList = materiaList;
	}

}