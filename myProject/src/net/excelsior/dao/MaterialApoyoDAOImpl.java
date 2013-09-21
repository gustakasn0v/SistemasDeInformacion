package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.MaterialApoyo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class MaterialApoyoDAOImpl implements MaterialApoyoDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	public void saveOrUpdateMaterialApoyo(MaterialApoyo material) {
		try {
			session.saveOrUpdate(material);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	
	public void deleteMaterialApoyo(String titulo) {
		try {
			MaterialApoyo material = (MaterialApoyo) session.get(MaterialApoyo.class, titulo);
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
		List<MaterialApoyo> materiales = null;
		try {
			materiales = session.createQuery("from MaterialApoyo Natural Join REALIZADO_POR where NOMBRE_USUARIO = '" + username + "'").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materiales;
	}

	/**
	 * Used to list a single user by Id.
	 */
	
	public MaterialApoyo listMaterialApoyoById(String Titulo) {
		MaterialApoyo material = null;
		try {
			material = (MaterialApoyo) session.get(MaterialApoyo.class, Titulo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return material;
	}

}
