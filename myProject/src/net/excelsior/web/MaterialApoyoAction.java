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

	private MaterialApoyo material = new MaterialApoyo();
	private List<MaterialApoyo> materialList = new ArrayList<MaterialApoyo>();
	private MaterialApoyoDAO materialDAO = new MaterialApoyoDAOImpl();
	
	
	public MaterialApoyo getModel() {
		return material;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String saveOrUpdate()
	{	
		materialDAO.saveOrUpdateMaterialApoyo(material);
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
		
		materialList = materialDAO.listMaterialApoyo(username);
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		materialDAO.deleteMaterialApoyo(request.getParameter("id"));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		material = materialDAO.listMaterialApoyoById(request.getParameter("id"));
		return SUCCESS;
	}
	
	public MaterialApoyo getMaterialApoyo() {
		return material;
	}

	public void setMaterialApoyo(MaterialApoyo material) {
		this.material = material;
	}

	public List<MaterialApoyo> getMaterialApoyoList() {
		return materialList;
	}

	public void setMaterialApoyoList(List<MaterialApoyo> materialList) {
		this.materialList = materialList;
	}

}
