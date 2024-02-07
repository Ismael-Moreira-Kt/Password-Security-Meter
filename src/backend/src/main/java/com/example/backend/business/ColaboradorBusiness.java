package com.example.backend.business;

import com.example.backend.entity.ColaboradorEntity;
import com.example.backend.repository.ColaboradorRepository;
import com.example.backend.util.SenhaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ColaboradorBusiness {
    @Autowired
    ColaboradorRepository colaboradorRepository;

    public ColaboradorEntity findById(Integer id) {
        return colaboradorRepository.findById(id).get();
    }

    public List<ColaboradorEntity> findAll() {
        return colaboradorRepository.findAll();
    }

    public ColaboradorEntity save(ColaboradorEntity colaboradorEntity) throws Exception {
        colaboradorEntity.setScore(SenhaUtil.calculaComplexidade(colaboradorEntity.getSenha()));
        colaboradorEntity.setSenha(SenhaUtil.criptografarSenha(colaboradorEntity.getSenha()));
        return colaboradorRepository.save(colaboradorEntity);
    }
}