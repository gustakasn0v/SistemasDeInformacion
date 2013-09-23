package net.excelsior.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.excelsior.domain.Profesor;
import net.excelsior.domain.MaterialApoyo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.opensymphony.xwork2.ActionContext;

public class MaterialApoyoDAOImpl implements MaterialApoyoDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	public void saveOrUpdateMaterialApoyo(MaterialApoyo material,String username) {
		try {
			material.profesores.add(new Profesor(username));
			session.saveOrUpdate(material);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	
	public void deleteMaterialApoyo(Long materialId) {
		try {
			MaterialApoyo material = (MaterialApoyo) session.get(MaterialApoyo.class, materialId);
			session.delete(material);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	
	public List<MaterialApoyo> listMaterialApoyo(String username) {
		Profesor testProfessor = new Profesor(username);
		List<MaterialApoyo> materiales = null;
		ArrayList<MaterialApoyo> listaFinal = new ArrayList<MaterialApoyo>();
		try {
			materiales = session.createQuery("from MaterialApoyo").list();
			Iterator<MaterialApoyo> iter = materiales.iterator();
			while (iter.hasNext()){
				MaterialApoyo checkedMaterial = iter.next();
				Object profs[] = checkedMaterial.profesores.toArray();
				int i;
				for(i=0;i<profs.length;i++){
					if ( testProfessor.equals(profs[i]) ){
						listaFinal.add(checkedMaterial);
					}
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFinal;
	}

	/**
	 * Used to list a single user by Id.
	 */
	
	public MaterialApoyo listMaterialApoyoById(Long materialId) {
		MaterialApoyo material = null;
		try {
			material = (MaterialApoyo) session.get(MaterialApoyo.class, materialId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return material;
	}

}
