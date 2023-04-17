package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
	Serie findBynom(String nom);
	Serie findByserieid(String id);
	List<Serie> findAll();
}
