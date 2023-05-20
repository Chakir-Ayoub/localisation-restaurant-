package com.example.demo.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Resto;
import com.example.demo.repository.RestoRepository;
import com.example.demo.service.RestoService;
import com.example.demo.sharedd.Utils;
import com.example.demo.shared.dto.RestoDto;

@Service
public class RestoServiceImpl implements RestoService {
	@Autowired
	RestoRepository repository;
	
	@Autowired
	Utils utils;
	@Override
	public RestoDto CreateResto(RestoDto dto) {
		// TODO Auto-generated method stub
		Resto check=repository.findBynom(dto.getNom());
		if(check!=null) throw new RuntimeException("Resto Already Exist");
		
		Resto resto=new Resto();
		BeanUtils.copyProperties(dto, resto);
		resto.setRestoid(utils.generateStringId(32));
		Resto newResto=repository.save(resto);
		RestoDto dto2=new RestoDto();
		
		BeanUtils.copyProperties(newResto, dto2);
		
		
		return dto2;
	}

	@Override
	public RestoDto GetAllByNom(String nom) {
		// TODO Auto-generated method stub
		Resto resto=repository.findBynom(nom);
		if(resto==null) throw new RuntimeException("Resto Not Found");
		RestoDto dto=new RestoDto();
		BeanUtils.copyProperties(resto, dto);
		return dto;
	}

	@Override
	public RestoDto Update(String id, RestoDto dto) {
		// TODO Auto-generated method stub
		Resto resto=repository.findByrestoid(id);
		if(resto==null) throw new RuntimeException("Resto Not Found");
		resto.setAdresse(dto.getAdresse());
		resto.setHeure_close(dto.getHeure_close());
		resto.setHeure_open(dto.getHeure_open());
		resto.setLatitude(dto.getLatitude());
		resto.setLongitude(dto.getLongitude());
		resto.setNom(dto.getNom());
		resto.setRank(dto.getRank());
		resto.setSerie(dto.getSerie());
		resto.setSpecialite(dto.getSpecialite());
		resto.setWeek(dto.getWeek());
		resto.setZone(dto.getZone());
		
		Resto updateResto=repository.save(resto);
		RestoDto dto2=new RestoDto();
		BeanUtils.copyProperties(updateResto, dto2);
		return dto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Resto resto=repository.findByrestoid(id);
		if(resto==null) throw new RuntimeException("Resto Not Found");
		
		repository.delete(resto);
		
	}

	@Override
	public List<RestoDto> GetAllResto() {
		// TODO Auto-generated method stub
		List<RestoDto> dtos=new ArrayList<>();
		List<Resto> list=repository.findAll();
		
		for (Resto resto : list) {
			RestoDto dto=new RestoDto();
			BeanUtils.copyProperties(resto, dto);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public RestoDto GetById(String id) {
		// TODO Auto-generated method stub
		Resto resto=repository.findByrestoid(id);
		
		RestoDto dto=new RestoDto();
		
		BeanUtils.copyProperties(resto, dto);
		return dto;
	}

}
