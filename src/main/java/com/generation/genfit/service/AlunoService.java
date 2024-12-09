package com.generation.genfit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.genfit.model.Aluno;
import com.generation.genfit.repository.AlunoRepository;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public float calcularImc(Aluno aluno){
        if(aluno.getAltura() <=0){
            throw new IllegalArgumentException("Altura não pode ser menor ou igual a zero");
        }

        float result = aluno.getPeso() / (aluno.getAltura() * aluno.getAltura());
        result = (float) (Math.round(result * 100.0) / 100.0);
        return result;
    }

    public String statusImc(Aluno aluno){
        float imc = calcularImc(aluno);
        if(imc < 18){
            return "Abaixo do peso";
        }else if(imc < 25){
            return "Peso normal";
        }else if(imc < 30){
            return "Sobrepeso";
        }else if(imc < 35){
            return "Obesidade grau 1";
        }else if(imc < 40){
            return "Obesidade grau 2";
        }else{
            return "Obesidade grau 3";
        } 
    }

    public List<Map<String, Object>> findByImc() {
        return alunoRepository.findAll().stream().map(aluno -> {
            Map<String, Object> response = new HashMap<>();
            response.put("aluno", aluno);
            response.put("imc", calcularImc(aluno));
            response.put("status", statusImc(aluno));
            return response;
        }).collect(Collectors.toList());
    }

}