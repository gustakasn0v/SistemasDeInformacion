package net.excelsior.dao;

import java.util.List;
import net.excelsior.domain.Tutoria;

public interface TutoriaDAO {

	public List<Tutoria> listTutoria(String username);
	public Tutoria listTutoriaById(Long Id);
	
}
