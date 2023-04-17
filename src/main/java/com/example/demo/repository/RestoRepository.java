package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Resto;

public interface RestoRepository extends JpaRepository<Resto, Integer> {
	Resto findBynom(String nom);
	Resto findByrestoid(String restoid);
}
