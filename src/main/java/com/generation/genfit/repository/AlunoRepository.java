package com.generation.genfit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.genfit.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
		
	public List<Aluno> findAllByNomeContainingIgnoreCase(@Param("nome")String nome);

}
