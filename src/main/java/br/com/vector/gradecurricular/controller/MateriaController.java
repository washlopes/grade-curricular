package br.com.vector.gradecurricular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vector.gradecurricular.entity.MateriaEntity;
import br.com.vector.gradecurricular.repository.IMateriaRepository;
import br.com.vector.gradecurricular.service.IMateriaService;

@RestController
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	@GetMapping
	public ResponseEntity<List <MateriaEntity>> obtemMaterias() {
		
		return ResponseEntity.status(HttpStatus.OK).body(materiaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <MateriaEntity> obtemMateria(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(materiaRepository.findById(id).get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluirMateria(@PathVariable Long id) {
		
		Boolean resultado = materiaService.excluir(id);
		
		if (resultado) {
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
		
	}
	
	@PutMapping
	public ResponseEntity <Boolean> atualizaMateria(@RequestBody MateriaEntity materia) {
		
		Boolean resultado = materiaService.atualizar(materia);
		
		if (resultado) {
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Boolean> cadastrarMateria(@RequestBody MateriaEntity materia) {
		
		Boolean resultado = materiaService.salvar(materia);
		
		if (resultado) {
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
		}
		
	}

}
