package net.excelsior.web;


import net.excelsior.dao.MateriaDAO;
import net.excelsior.dao.MateriaDAOImpl;
import net.excelsior.dao.MaterialApoyoDAO;
import net.excelsior.dao.MaterialApoyoDAOImpl;
import net.excelsior.dao.TituloDAO;
import net.excelsior.dao.TituloDAOImpl;
import net.excelsior.domain.Materia;
import net.excelsior.domain.MaterialApoyo;
import net.excelsior.domain.Titulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.validator.Valid;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TablaAction extends ActionSupport {

	private static final long serialVersionUID = -6659925652584240539L;
	
	@Valid
	private Materia materia = new Materia();
	private List<Materia> materiaList = new ArrayList<Materia>();
	private MateriaDAO materiaDAO = new MateriaDAOImpl();
	
	@Valid
	private Titulo titulo = new Titulo();
	private List<Titulo> tituloList = new ArrayList<Titulo>();
	private TituloDAO tituloDAO = new TituloDAOImpl();
	
	@Valid
	private MaterialApoyo materialApoyo = new MaterialApoyo();
	private List<MaterialApoyo> materialApoyoList = new ArrayList<MaterialApoyo>();
	private MaterialApoyoDAO materialApoyoDAO = new MaterialApoyoDAOImpl();
	
	
//	public Materia getModel() {
//		return materia;
//	}
	
	
	/**
	 * To save or update user.
	 * @return String
	 */
//	public String saveOrUpdate()
//	{	
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		String username = (String) session.get("username");
//		materiaDAO.saveOrUpdateMateria(materia,username);
//		return SUCCESS;
//	}
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		materiaList = materiaDAO.listMateria(username);
		setMaterialApoyoList(materialApoyoDAO.listMaterialApoyo(username));
		setTituloList(tituloDAO.listTitulo(username));
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
//	public String delete()
//	{
//		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//		System.out.println(request.getParameter("id"));
//		materiaDAO.deleteMateria(Long.parseLong(request.getParameter("id")));
//		return SUCCESS;
//	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
//	public String edit()
//	{
//		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
//		materia = materiaDAO.listMateriaById(Long.parseLong(request.getParameter("id")));
//		return SUCCESS;
//	}
	
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

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public List<Titulo> getTituloList() {
		return tituloList;
	}

	public void setTituloList(List<Titulo> tituloList) {
		this.tituloList = tituloList;
	}

	public MaterialApoyo getMaterialApoyo() {
		return materialApoyo;
	}

	public void setMaterialApoyo(MaterialApoyo materialApoyo) {
		this.materialApoyo = materialApoyo;
	}

	public List<MaterialApoyo> getMaterialApoyoList() {
		return materialApoyoList;
	}

	public void setMaterialApoyoList(List<MaterialApoyo> materialApoyoList) {
		this.materialApoyoList = materialApoyoList;
	}

}