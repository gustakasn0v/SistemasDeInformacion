package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.MaterialApoyo;

public interface MaterialApoyoDAO {

	public void saveOrUpdateMaterialApoyo(MaterialApoyo material);
	public List<MaterialApoyo> listMaterialApoyo(String username);
	public MaterialApoyo listMaterialApoyoById(String titulo);
	public void deleteMaterialApoyo(String titulo);
}
