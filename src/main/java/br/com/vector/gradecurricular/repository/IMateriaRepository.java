package br.com.vector.gradecurricular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vector.gradecurricular.entity.MateriaEntity;

@Repository
public interface IMateriaRepository extends JpaRepository<MateriaEntity, Long>{

}
