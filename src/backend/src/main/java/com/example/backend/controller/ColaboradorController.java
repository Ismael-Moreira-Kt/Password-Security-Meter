package com.example.backend.controller;

import com.example.backend.business.ColaboradorBusiness;
import com.example.backend.entity.ColaboradorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController("/colaboradores")
public class ColaboradorController {

    @Autowired
    ColaboradorBusiness colaboradorBusiness;

    @GetMapping("/{id}")
    public ColaboradorEntity get(@PathVariable Integer id){
        return colaboradorBusiness.findById(id);
    }

    @GetMapping("/")
    public List<ColaboradorEntity> get(){
        return colaboradorBusiness.findAll();
    }

    @PostMapping()
    public ColaboradorEntity post(@RequestBody ColaboradorEntity colaboradorEntity) throws Exception{
        return colaboradorBusiness.save(colaboradorEntity);
    }
}