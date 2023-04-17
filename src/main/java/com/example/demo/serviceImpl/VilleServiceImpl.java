package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ville;
import com.example.demo.reponse.VilleResponse;
import com.example.demo.repository.VilleRepository;
import com.example.demo.service.VilleService;
import com.example.demo.sharedd.Utils;
import com.example.demo.shared.dto.VilleDto;

@Service
public class VilleServiceImpl implements VilleService {
	@Autowired
	VilleRepository repository;
	@Autowired
	Utils utils;
	@Override
	public VilleDto CreateVille(VilleDto dto) {
		// TODO Auto-generated method stub
		Ville ville =new Ville();
		BeanUtils.copyProperties(dto, ville);
		
		ville.setVilleid(utils.generateStringId(32));

		Ville villle=repository.save(ville);
		VilleDto villeDto =new VilleDto();
		
		BeanUtils.copyProperties(villle, villeDto);
		return villeDto;
	}

	@Override
	public VilleDto GetByNom(String nom) {
		// TODO Auto-generated method stub
		Ville ville=repository.findBynom(nom);
		VilleDto dto=new VilleDto();
		BeanUtils.copyProperties(ville, dto);
		return dto;
	}

	@Override
	public VilleDto Update(String id, VilleDto villeDto) {
		// TODO Auto-generated method stub
		Ville ville=repository.findByvilleid(id);
		if(ville==null) throw new RuntimeException();
		ville.setNom(villeDto.getNom());
		
		Ville villeupdate=repository.save(ville);
		VilleDto dto=new VilleDto();
		BeanUtils.copyProperties(villeupdate, dto);
		return dto;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Ville ville=repository.findByvilleid(id);
		if(ville==null) throw new RuntimeException("Ville Not exist");
		repository.delete(ville);
	}

	@Override
	public List<VilleDto> GetAllVille() {
		// TODO Auto-generated method stub
		List<VilleDto> dtoss=new ArrayList<>();
		List<Ville> dtos=repository.findAll();
		
		for (Ville ville : dtos) {
			VilleDto dto=new VilleDto();
			
			BeanUtils.copyProperties(ville, dto);
			
			dtoss.add(dto);
		}
		return dtoss;
	}

	@Override
	public VilleDto GetById(String id) {
		// TODO Auto-generated method stub
		Ville ville=repository.findByvilleid(id);
		VilleDto dto=new VilleDto();
		
		BeanUtils.copyProperties(ville, dto);
		return dto;
	}

}
