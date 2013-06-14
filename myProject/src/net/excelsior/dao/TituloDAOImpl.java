package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.Titulo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class TituloDAOImpl implements TituloDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	public void saveOrUpdateTitulo(Titulo titulo) {
		try {
			session.saveOrUpdate(titulo);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	
	public void deleteTitulo(Long tituloId) {
		try {
			Titulo titulo = (Titulo) session.get(Titulo.class, tituloId);
			session.delete(titulo);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	
	public List<Titulo> listTitulo(String username) {
		List<Titulo> courses = null;
		try {
			courses = session.createQuery("from Titulo where nombreusuario = '" + username + "'").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single user by Id.
	 */
	
	public Titulo listTituloById(Long tituloId) {
		Titulo titulo = null;
		try {
			titulo = (Titulo) session.get(Titulo.class, tituloId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return titulo;
	}

}
