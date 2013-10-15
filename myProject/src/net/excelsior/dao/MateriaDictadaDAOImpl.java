package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.MateriaDictada;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class MateriaDictadaDAOImpl implements MateriaDictadaDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	
	public List<MateriaDictada> listMateriaDictada(String username) {
		List<MateriaDictada> MateriaDictada = null;
		try {
			MateriaDictada = session.createQuery("from MateriaDictada where nombreUsuario = '"+username+"'").list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MateriaDictada;
	}

	/**
	 * Used to list a single user by Id.
	 */
	
	public MateriaDictada listMateriaDictadaById(Long MateriaDictadaId) {
		MateriaDictada MateriaDictada = null;
		try {
			MateriaDictada = (MateriaDictada) session.get(MateriaDictada.class, MateriaDictadaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MateriaDictada;
	}

}
