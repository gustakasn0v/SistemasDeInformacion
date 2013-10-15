package net.excelsior.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.excelsior.domain.Profesor;
import net.excelsior.domain.MateriaModificada;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.opensymphony.xwork2.ActionContext;

public class MateriaModificadaDAOImpl implements MateriaModificadaDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	public void saveOrUpdateMateriaModificada(MateriaModificada materiaModificada,String username) {
		try {
			materiaModificada.profesores.add(new Profesor(username));
			session.saveOrUpdate(materiaModificada);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	
	public void deleteMateriaModificada(Long materiaModificadaId) {
		try {
			MateriaModificada materiaModificada = (MateriaModificada) session.get(MateriaModificada.class, materiaModificadaId);
			session.delete(materiaModificada);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	
	public List<MateriaModificada> listMateriaModificada(String username) {
		Profesor testProfessor = new Profesor(username);
		List<MateriaModificada> materiaModificada = null;
		ArrayList<MateriaModificada> listaFinal = new ArrayList<MateriaModificada>();
		try {
			materiaModificada = session.createQuery("from MateriaModificada").list();
			Iterator<MateriaModificada> iter = materiaModificada.iterator();
			while (iter.hasNext()){
				MateriaModificada checkedMateria = iter.next();
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
	
	public MateriaModificada listMateriaModificadaById(Long materiaModificadaId) {
		MateriaModificada materiaModificada = null;
		try {
			materiaModificada = (MateriaModificada) session.get(MateriaModificada.class, materiaModificadaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return materiaModificada;
	}

}
