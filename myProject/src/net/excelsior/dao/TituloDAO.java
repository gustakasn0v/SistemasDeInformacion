package net.excelsior.dao;

import java.util.List;
import net.excelsior.domain.Titulo;

public interface TituloDAO {

	public void saveOrUpdateTitulo(Titulo titulo);
	public List<Titulo> listTitulo();
	public Titulo listTituloById(Long userId);
	public void deleteTitulo(Long userId);
}
