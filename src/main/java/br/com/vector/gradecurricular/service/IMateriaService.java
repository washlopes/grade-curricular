package br.com.vector.gradecurricular.service;

import br.com.vector.gradecurricular.entity.MateriaEntity;

public interface IMateriaService {
	
	public Boolean atualizar(final MateriaEntity materia);
	
	public Boolean excluir(final Long id);
	
	public Boolean salvar(final MateriaEntity materia);
	
	

}
