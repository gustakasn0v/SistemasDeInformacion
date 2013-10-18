package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.OtraActividad;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class OtraActividadDAOImpl implements OtraActividadDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	
	public List<OtraActividad> listOtraActividad(String username) {
		List<OtraActividad> OtraActividad = null;
		try {
			OtraActividad = session.createQuery("from OtraActividad where nombre_usuario_prof = '"+username+"'").list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OtraActividad;
	}

	/**
	 * Used to list a single user by Id.
	 */
	
	public OtraActividad listOtraActividadById(Long OtraActividadId) {
		OtraActividad OtraActividad = null;
		try {
			OtraActividad = (OtraActividad) session.get(OtraActividad.class, OtraActividadId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return OtraActividad;
	}

}
