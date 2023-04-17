package com.example.demo.service;

import java.util.List;

import com.example.demo.shared.dto.VilleDto;

public interface VilleService {
	VilleDto CreateVille(VilleDto dto);
	VilleDto GetByNom(String nom);
	VilleDto Update(String id,VilleDto villeDto);
	void Delete(String id);
	List<VilleDto> GetAllVille();
	VilleDto GetById(String id);
}
