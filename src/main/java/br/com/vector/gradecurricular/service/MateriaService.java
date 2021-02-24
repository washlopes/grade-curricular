package br.com.vector.gradecurricular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.vector.gradecurricular.entity.MateriaEntity;
import br.com.vector.gradecurricular.repository.IMateriaRepository;

@Service
public class MateriaService implements IMateriaService {

	@Autowired
	private IMateriaRepository materiaRepository;
	
	
	@Override
	public Boolean atualizar(MateriaEntity materia) {
		// TODO Auto-generated method stub
		try {
			MateriaEntity materiaEntityAtualizada = this.materiaRepository.findById(materia.getId()).get();
			
			materiaEntityAtualizada.setNome(materia.getNome());
			materiaEntityAtualizada.setCodigo(materia.getCodigo());
			materiaEntityAtualizada.setHoras(materia.getHoras());
			materiaEntityAtualizada.setFrequencia(materia.getFrequencia());
			
			this.materiaRepository.save(materiaEntityAtualizada);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean excluir(Long id) {
		// TODO Auto-generated method stub
		Boolean excluido = false;
		
		try {
			if (materiaRepository.findById(id).isPresent()) {
				materiaRepository
				.delete(materiaRepository.findById(id).get());
				excluido = true;
			}
			return excluido;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean salvar(MateriaEntity materia) {
		// TODO Auto-generated method stub
		try {
			this.materiaRepository.save(materia);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
}
