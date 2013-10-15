package net.excelsior.dao;

import java.util.List;

import net.excelsior.domain.MateriaDictada;

public interface MateriaDictadaDAO {

	public List<MateriaDictada> listMateriaDictada(String username);
	public MateriaDictada listMateriaDictadaById(Long MateriaDictadaId);
}