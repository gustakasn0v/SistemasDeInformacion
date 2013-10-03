package net.excelsior.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.excelsior.domain.Profesor;
import net.excelsior.domain.Materia;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.opensymphony.xwork2.ActionContext;

public class MateriaDAOImpl implements MateriaDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	public void saveOrUpdateMateria(Materia materia,String username) {
		try {
			materia.profesores.add(new Profesor(username));
			session.saveOrUpdate(materia);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	
	public void deleteMateria(Long materiaId) {
		try {
			Materia materia = (Materia) session.get(Materia.class, materiaId);
			session.delete(materia);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	
	public List<Materia> listMateria(String username) {
		Profesor testProfessor = new Profesor(username);
		List<Materia> materia = null;
		ArrayList<Materia> listaFinal = new ArrayList<Materia>();
		try {
			materia = session.createQuery("from Materia").list();
			Iterator<Materia> iter = materia.iterator();
			while (iter.hasNext()){
				Materia checkedMateria = iter.next();
				Object profs[] = checkedMateria.profesores.toArray();
				int i;
				for(i=0;i<profs.length;i++){
					if ( testProfessor.equals(profs[i]) ){
						listaFinal.add(checkedMateria);
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
	
	public Materia listMateriaById(Long materiaId) {
		Materia materia = null;
		try {
			materia = (Materia) session.get(Materia.class, materiaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materia;
	}

}
