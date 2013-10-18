package net.excelsior.web;


import net.excelsior.dao.MateriaDictadaDAO;
import net.excelsior.dao.MateriaDictadaDAOImpl;
import net.excelsior.dao.MateriaModificadaDAO;
import net.excelsior.dao.MateriaModificadaDAOImpl;
import net.excelsior.dao.MaterialApoyoDAO;
import net.excelsior.dao.MaterialApoyoDAOImpl;
import net.excelsior.dao.TituloDAO;
import net.excelsior.dao.TituloDAOImpl;
import net.excelsior.domain.MateriaDictada;
import net.excelsior.domain.MateriaModificada;
import net.excelsior.domain.MaterialApoyo;
import net.excelsior.domain.Titulo;
import net.excelsior.domain.Tutoria;
import net.excelsior.dao.TutoriaDAO;
import net.excelsior.dao.TutoriaDAOImpl;
import net.excelsior.dao.OtraActividadDAO;
import net.excelsior.dao.OtraActividadDAOImpl;
import net.excelsior.domain.OtraActividad;


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
	private MateriaModificada materiaModificada = new MateriaModificada();
	private List<MateriaModificada> materiaModificadaList = new ArrayList<MateriaModificada>();
	private MateriaModificadaDAO materiaModificadaDAO = new MateriaModificadaDAOImpl();
	
	@Valid
	private Titulo titulo = new Titulo();
	private List<Titulo> tituloList = new ArrayList<Titulo>();
	private TituloDAO tituloDAO = new TituloDAOImpl();
	
	@Valid
	private MaterialApoyo materialApoyo = new MaterialApoyo();
	private List<MaterialApoyo> materialApoyoList = new ArrayList<MaterialApoyo>();
	private MaterialApoyoDAO materialApoyoDAO = new MaterialApoyoDAOImpl();
	
	private MateriaDictada materiaDictada = new MateriaDictada();
	private List<MateriaDictada> materiaDictadaList = new ArrayList<MateriaDictada>();
	private MateriaDictadaDAO materiaDictadaDAO = new MateriaDictadaDAOImpl();
	
	private Tutoria tutoria = new Tutoria();
	private List<Tutoria> tutoriaList = new ArrayList<Tutoria>();
	private TutoriaDAO tutoriaDAO = new TutoriaDAOImpl();
	
	private OtraActividad otraActividad = new OtraActividad();
	private List<OtraActividad> otraActividadList = new ArrayList<OtraActividad>();
	private OtraActividadDAO otraActividadDAO = new OtraActividadDAOImpl();
	
	/**
	 * To list all users.
	 * @return String
	 */
	public String list()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		
		setMateriaModificadaList(materiaModificadaDAO.listMateriaModificada(username));
		setMaterialApoyoList(materialApoyoDAO.listMaterialApoyo(username));
		setTituloList(tituloDAO.listTitulo(username));
		setMateriaDictadaList(materiaDictadaDAO.listMateriaDictada(username));
		setTutoriaList(tutoriaDAO.listTutoria(username));
		setOtraActividadList(otraActividadDAO.listOtraActividad(username));
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
	
	public Tutoria getTutoria(){
		return tutoria;
	}
	
	public void setTutoria(Tutoria tutoria){
		this.tutoria = tutoria;
	}
	
	public List<Tutoria> getTutoriaList(){
		return tutoriaList;
	}
	
	public void setTutoriaList(List<Tutoria> tutoriaList){
		this.tutoriaList = tutoriaList;
	}

	public void setOtraActividadList(List<OtraActividad> otraActividadList){
		this.otraActividadList = otraActividadList;
	}
	
	public List<OtraActividad> getOtraActividadList(){
		return otraActividadList;
	}
	
	public OtraActividad getOtraActividad(){
		return otraActividad;
	}
	
	public void setOtraActividad(OtraActividad otraActividad){
		this.otraActividad = otraActividad;
	}
}