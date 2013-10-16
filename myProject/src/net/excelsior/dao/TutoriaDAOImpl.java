package net.excelsior.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import net.excelsior.domain.Tutoria;

public class TutoriaDAOImpl implements TutoriaDAO {

	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	
	@SuppressWarnings("unchecked")
	public List<Tutoria> listTutoria(String username) {
		List<Tutoria> tutorias = null;
		try{
			tutorias = session.createQuery("from Tutoria where nombreUsuario = '" + username + "'").list();
		} catch (Exception e){
			e.printStackTrace();
		}
		return tutorias;
	}

	public Tutoria listTutoriaById(Long Id) {
		Tutoria tutoria = null;
		try {
			tutoria = (Tutoria) session.get(Tutoria.class, Id);
		} catch (Exception e){
			e.printStackTrace();
		}
		return tutoria;
	}

}
