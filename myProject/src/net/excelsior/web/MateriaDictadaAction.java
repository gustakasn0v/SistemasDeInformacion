package net.excelsior.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import net.excelsior.dao.MateriaDictadaDAO;
import net.excelsior.dao.MateriaDictadaDAOImpl;
import net.excelsior.domain.MateriaDictada;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MateriaDictadaAction extends ActionSupport implements ModelDriven<MateriaDictada> {

	private static final long serialVersionUID = -6659925652584240539L;

	private MateriaDictada materiaDictada = new MateriaDictada();
	private List<MateriaDictada> materiaDictadaList = new ArrayList<MateriaDictada>();
	private MateriaDictadaDAO materiaDictadaDAO = new MateriaDictadaDAOImpl();
	
	
	public MateriaDictada getModel() {
		return materiaDictada;
	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		materiaDictadaList = materiaDictadaDAO.listMateriaDictada(username);
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	
	public MateriaDictada getMateriaDictada() {
		return materiaDictada;
	}

	public void setMateriaDictada(MateriaDictada MateriaDictada) {
		this.materiaDictada = MateriaDictada;
	}

	public List<MateriaDictada> getMateriaDictadaList() {
		return materiaDictadaList;
	}

	public void setMateriaDictadaList(List<MateriaDictada> MateriaDictadaList) {
		this.materiaDictadaList = MateriaDictadaList;
	}

}