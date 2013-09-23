package net.excelsior.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.excelsior.dao.MaterialApoyoDAO;
import net.excelsior.dao.MaterialApoyoDAOImpl;
import net.excelsior.domain.MaterialApoyo;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MaterialApoyoAction extends ActionSupport implements ModelDriven<MaterialApoyo> {

	private static final long serialVersionUID = -6659925652584240539L;

	private MaterialApoyo materialApoyo = new MaterialApoyo();
	private List<MaterialApoyo> materialApoyoList = new ArrayList<MaterialApoyo>();
	private MaterialApoyoDAO materialApoyoDAO = new MaterialApoyoDAOImpl();
	
	
	public MaterialApoyo getModel() {
		return materialApoyo;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		materialApoyoDAO.saveOrUpdateMaterialApoyo(materialApoyo,username);
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
		
		materialApoyoList = materialApoyoDAO.listMaterialApoyo(username);
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
		materialApoyoDAO.deleteMaterialApoyo(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		materialApoyo = materialApoyoDAO.listMaterialApoyoById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public MaterialApoyo getMaterialApoyo() {
		return materialApoyo;
	}

	public void setMaterialApoyo(MaterialApoyo material) {
		this.materialApoyo = material;
	}

	public List<MaterialApoyo> getMaterialApoyoList() {
		return materialApoyoList;
	}

	public void setMaterialApoyoList(List<MaterialApoyo> materialList) {
		this.materialApoyoList = materialList;
	}

}
