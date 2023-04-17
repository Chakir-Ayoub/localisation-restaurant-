package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
	Ville findBynom(String nom);
	Ville findByvilleid(String id);
}
