package net.excelsior.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import net.excelsior.domain.Titulo;

public class TituloDAOImpl implements TituloDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**Titulo
	 * Used to save or update a user.
	 */
	@Override
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
	@Override
	public void deleteTitulo(Long userId) {
		try {
			Titulo titulo = (Titulo) session.get(Titulo.class, userId);
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
	@Override
	public List<Titulo> listTitulo() {
		List<Titulo> result = null;
		try {
			result = (List<Titulo>) session.createQuery("from net.excelsior.domain.Titulo").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public Titulo listTituloById(Long userId) {
		Titulo titulo = null;
		try {
			titulo = (Titulo) session.get(Titulo.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return titulo;
	}

}
