package com.example.backend.repository;

import com.example.backend.entity.ColaboradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorEntity, Integer> {}