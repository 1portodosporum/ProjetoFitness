package com.generation.genfit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_treinos")
public class Treino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O Atributo tipo é Obrigatorio!")
	@Size(min = 2, max = 50, message = "O Atributo tipo deve ter entre 2 e 50 caracteres")
	private String tipo;

	@Size(min = 2, max = 30, message = "O Atributo periodo deve ter entre 2 e 30 caracteres")
	private String periodo;

	@Size(min = 2, max = 30, message = "O Atributo nivel deve ter entre 2 e 30 caracteres")
	private String nivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
