package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Specialite;
import com.example.demo.repository.SpecialiteRepository;
import com.example.demo.service.SpecialiteService;
import com.example.demo.sharedd.Utils;
import com.example.demo.shared.dto.SpecialiteDto;

@Service
public class SpecialiteServiceImpl implements SpecialiteService {
	
	@Autowired
	SpecialiteRepository repository;
	@Autowired
	Utils utils;
	@Override
	public SpecialiteDto CreateSpecialite(SpecialiteDto dto) {
		// TODO Auto-generated method stub
		Specialite specialite=new Specialite();
		BeanUtils.copyProperties(dto, specialite);
		
		specialite.setSpecialiteid(utils.generateStringId(32));
		
		Specialite specialite2=repository.save(specialite);
		SpecialiteDto dto2=new SpecialiteDto();
		
		BeanUtils.copyProperties(specialite2, dto2);
		return dto2;
	}

	@Override
	public SpecialiteDto GetByNom(String nom) {
		// TODO Auto-generated method stub
		Specialite specialite=repository.findBynom(nom);
		SpecialiteDto dto=new SpecialiteDto();
		BeanUtils.copyProperties(specialite, dto);
		return dto;
	}

	@Override
	public SpecialiteDto Update(String id, SpecialiteDto dto) {
		// TODO Auto-generated method stub
		Specialite specialite=repository.findByspecialiteid(id);
		specialite.setNom(dto.getNom());
		
		Specialite updateSpecialite=repository.save(specialite);
		SpecialiteDto dto2=new SpecialiteDto();
		BeanUtils.copyProperties(updateSpecialite, dto2);
		return dto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Specialite specialite=repository.findByspecialiteid(id);
		if(specialite==null) throw new RuntimeException("Specialite Not exist");
		repository.delete(specialite);
	}

	@Override
	public List<SpecialiteDto> GetallSpecialite() {
		// TODO Auto-generated method stub
		List<SpecialiteDto> specialiteDtos =new ArrayList<>();
		List<Specialite> specialites=repository.findAll();
		
		for (Specialite specialite : specialites) {
			SpecialiteDto dto=new SpecialiteDto();
			BeanUtils.copyProperties(specialite, dto);
			
			specialiteDtos.add(dto);
		}
		return specialiteDtos;
	}

	@Override
	public SpecialiteDto GetBiId(String id) {
		// TODO Auto-generated method stub
		Specialite specialite=repository.findByspecialiteid(id);
		
		SpecialiteDto dto=new SpecialiteDto();
		BeanUtils.copyProperties(specialite, dto);
		return dto;
	}

}
