package com.example.demo.service;

import java.util.List;

import com.example.demo.shared.dto.SerieDto;

public interface SerieService {
	SerieDto CreateSerie(SerieDto dto);
	SerieDto GetBynom(String nom);
	SerieDto Update(String id,SerieDto dto);
	void Delete(String id);
	List<SerieDto> GetAllSerie();
	SerieDto GetById(String id);
	
}
