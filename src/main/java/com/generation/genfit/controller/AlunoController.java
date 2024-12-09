package com.generation.genfit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.genfit.model.Aluno;
import com.generation.genfit.repository.AlunoRepository;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

@Autowired
private AlunoRepository alunoRepository;

@GetMapping
public ResponseEntity<List<Aluno>> getAll() {
return ResponseEntity.ok(alunoRepository.findAll());

}

@GetMapping("/{id}")
public ResponseEntity<Aluno> getById(@PathVariable Long id) {
return alunoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
}

@GetMapping("/nome/{nome}")
public ResponseEntity<List<Aluno>> getByNome(@PathVariable String nome) {
return ResponseEntity.ok(alunoRepository.findAllByNomeContainingIgnoreCase(nome));
}
@PostMapping
public ResponseEntity<Aluno> post(@Valid @RequestBody Aluno aluno) {
return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
}

@PutMapping
public ResponseEntity<Aluno> put(@Valid @RequestBody Aluno aluno){
return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(aluno));
}
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
Optional<Aluno> aluno = alunoRepository.findById(id);

if(aluno.isEmpty()) {
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}

alunoRepository.deleteById(id);
}
}