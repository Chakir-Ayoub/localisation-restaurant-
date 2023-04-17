package com.example.demo.service;

import java.util.List;

import com.example.demo.shared.dto.SpecialiteDto;

public interface SpecialiteService {
	SpecialiteDto CreateSpecialite(SpecialiteDto dto);
	SpecialiteDto GetByNom(String nom);
	SpecialiteDto Update(String id,SpecialiteDto dto);
	void Delete(String id);
	List<SpecialiteDto> GetallSpecialite(int page,int limit);
}
