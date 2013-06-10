package net.excelsior.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.excelsior.dao.TituloDAO;
import net.excelsior.dao.TituloDAOImpl;
import net.excelsior.domain.Titulo;

public class TituloAction extends ActionSupport implements ModelDriven<Titulo> {

	private static final long serialVersionUID = -6659925652584240539L;

	private Titulo titulo = new Titulo();
	private List<Titulo> userList = new ArrayList<Titulo>();
	private TituloDAO userDAO = new TituloDAOImpl();
	
	@Override
	public Titulo getModel() {
		return titulo;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		userDAO.saveOrUpdateTitulo(titulo);
		return SUCCESS;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		userList = userDAO.listTitulo();
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		userDAO.deleteTitulo(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		titulo = userDAO.listTituloById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public Titulo getUser() {
		return titulo;
	}

	public void setUser(Titulo user) {
		this.titulo = user;
	}

	public List<Titulo> getUserList() {
		return userList;
	}

	public void setTituloList(List<Titulo> userList) {
		this.userList = userList;
	}

}
