package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.html.parser.DTD;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Serie;
import com.example.demo.repository.SerieRepository;
import com.example.demo.service.SerieService;
import com.example.demo.sharedd.Utils;
import com.example.demo.shared.dto.SerieDto;

@Service
public class SerieServiceImpl implements SerieService {
	
	@Autowired
	SerieRepository repository;
	@Autowired
	Utils utils;
	@Override
	public SerieDto CreateSerie(SerieDto dto) {
		Serie serie=new Serie();
		BeanUtils.copyProperties(dto, serie);
		
		serie.setSerieid(utils.generateStringId(32));
		
		Serie serie2=repository.save(serie);
		SerieDto dto2=new SerieDto();
		
		BeanUtils.copyProperties(serie2, dto2);
		return dto2;
	}

	@Override
	public SerieDto GetBynom(String nom) {
		Serie serie=repository.findBynom(nom);
		SerieDto dto=new SerieDto();
		BeanUtils.copyProperties(serie, dto);
		return dto;
	}

	@Override
	public SerieDto Update(String id, SerieDto dto) {
		// TODO Auto-generated method stub
		Serie serie=repository.findByserieid(id);
		if(serie==null) throw new RuntimeException("Serie Not Found");
		
		serie.setNom(dto.getNom());
		
		Serie updateserie=repository.save(serie);
		SerieDto dto2=new SerieDto();
		BeanUtils.copyProperties(updateserie, dto2);
		return dto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Serie serie=repository.findByserieid(id);
		if(serie==null) throw new RuntimeException("Serie Not Found");
		
		repository.delete(serie);
	}

	@Override
	public List<SerieDto> GetAllSerie() {
		// TODO Auto-generated method stub
		 List<SerieDto> serieDto=new ArrayList<>();
		 List<Serie> serielist=repository.findAll();
		 
		 for (Serie serie : serielist) {
			SerieDto seriedto=new SerieDto();
			BeanUtils.copyProperties(serie, seriedto);
			
			serieDto.add(seriedto);
		}
		 
		 return serieDto;
	}

	@Override
	public SerieDto GetById(String id) {
		// TODO Auto-generated method stub
		Serie serie=repository.findByserieid(id);
		
		SerieDto dto=new SerieDto();
		BeanUtils.copyProperties(serie, dto);
		return dto;
	}

}
