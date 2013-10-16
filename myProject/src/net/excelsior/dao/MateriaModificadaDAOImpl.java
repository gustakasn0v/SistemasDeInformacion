package net.excelsior.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.excelsior.domain.Profesor;
import net.excelsior.domain.MateriaModificada;
import net.excelsior.domain.Titulo;

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
			List<MateriaModificada> materiaModificadaList = null;
			materiaModificadaList = session.createQuery("from MateriaModificada where codigo = '"+materiaModificada.getCodigo()+"'").list();
			MateriaModificada instanciaVieja = materiaModificadaList.get(0);
			instanciaVieja.profesores.add(new Profesor(username));
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	
	public void deleteMateriaModificada(Long materiaModificadaId,String username) {
		try {
			MateriaModificada instanciaVieja =(MateriaModificada) session.get(MateriaModificada.class, materiaModificadaId);
			List<Profesor> profesorList = session.createQuery("from Profesor where nombreUsuario = '"+username+"'").list();
			instanciaVieja.profesores.remove(profesorList.get(0));
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
