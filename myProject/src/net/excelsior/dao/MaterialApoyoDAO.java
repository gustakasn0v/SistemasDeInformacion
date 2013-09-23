package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.MaterialApoyo;

public interface MaterialApoyoDAO {

	public void saveOrUpdateMaterialApoyo(MaterialApoyo material,String username);
	public List<MaterialApoyo> listMaterialApoyo(String username);
	public MaterialApoyo listMaterialApoyoById(Long id);
	public void deleteMaterialApoyo(Long id);
}
