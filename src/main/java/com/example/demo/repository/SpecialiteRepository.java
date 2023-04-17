package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {
  Specialite findBynom(String nom);
  Specialite findByspecialiteid(String id);
}
