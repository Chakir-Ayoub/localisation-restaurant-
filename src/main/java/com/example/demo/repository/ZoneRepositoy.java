package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Zone;



public interface ZoneRepositoy extends JpaRepository<Zone,Integer >{
	Zone findBynom(String nom);
	Zone findByzoneid(String id);
}
