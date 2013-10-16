package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.MateriaModificada;

public interface MateriaModificadaDAO {

	public void saveOrUpdateMateriaModificada(MateriaModificada materiaModificada,String username);
	public List<MateriaModificada> listMateriaModificada(String username);
	public MateriaModificada listMateriaModificadaById(Long materiaModificadaId);
	public void deleteMateriaModificada(Long materiaModificadaId,String username);
}