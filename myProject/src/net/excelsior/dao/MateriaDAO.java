package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.Materia;

public interface MateriaDAO {

	public void saveOrUpdateMateria(Materia materia,String username);
	public List<Materia> listMateria(String username);
	public Materia listMateriaById(Long materiaId);
	public void deleteMateria(Long materiaId);
}