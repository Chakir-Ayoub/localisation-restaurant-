package com.example.demo.service;

import java.util.List;

import com.example.demo.shared.dto.RestoDto;

public interface RestoService {
	RestoDto CreateResto(RestoDto dto);
	RestoDto GetAllByNom(String nom);
	RestoDto Update(String id,RestoDto dto);
	void Delete(String id);
	List<RestoDto> GetAllResto();
	RestoDto GetById(String id);
}
