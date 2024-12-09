package com.generation.genfit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.genfit.model.Treino;

public interface TreinoRepository extends JpaRepository <Treino, Long>{
	
	public List<Treino> findAllByTipoContainingIgnoreCase(@Param("tipo") String tipo);	

}
