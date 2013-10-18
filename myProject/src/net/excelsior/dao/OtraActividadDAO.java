package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.OtraActividad;

public interface OtraActividadDAO {
	public List<OtraActividad> listOtraActividad(String username);
	public OtraActividad listOtraActividadById(Long OtraActividadId);
}
