package com.example.backend.entity;


import jakarta.persistence.*;

@Entity(name="COLABORADORES")
public class ColaboradorEntity {
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }




    @Id
    @GeneratedValue
    @Column(name="ID")
    Integer id;

    @Column(name="NOME")
    String nome;

    @Column(name="SENHA")
    String senha;

    @Column(name="SCORE")
    String score;
}