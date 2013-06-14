package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.Titulo;

public interface TituloDAO {

	public void saveOrUpdateTitulo(Titulo titulo);
	public List<Titulo> listTitulo(String username);
	public Titulo listTituloById(Long tituloId);
	public void deleteTitulo(Long tituloId);
}
