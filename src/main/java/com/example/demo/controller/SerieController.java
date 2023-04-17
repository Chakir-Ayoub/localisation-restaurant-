package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.reponse.SerieResponse;
import com.example.demo.request.SerieRequest;
import com.example.demo.service.PhotoService;
import com.example.demo.service.SerieService;
import com.example.demo.shared.dto.SerieDto;

@RestController
@RequestMapping("/serie")
public class SerieController {
	@Autowired
	SerieService service;
	
	@PostMapping()
	public SerieResponse save(@RequestBody SerieRequest request) {
		SerieDto dto=new SerieDto();
		BeanUtils.copyProperties(request, dto);
		
		SerieDto createserie=service.CreateSerie(dto);
		SerieResponse response=new SerieResponse();
		BeanUtils.copyProperties(createserie, response);
		
		return response;
	}
	
	@GetMapping(path = "/{nom}")
	public SerieResponse getByNom(@PathVariable String nom) {
		SerieDto dto=service.GetBynom(nom);
		SerieResponse response=new SerieResponse();
		BeanUtils.copyProperties(dto, response);
		return response;
	}
	
	@GetMapping
	public List<SerieResponse> GetAll(){
		List<SerieResponse> serresp=new ArrayList<>();
		List<SerieDto> serie=service.GetAllSerie();
		for (SerieDto serieDto : serie) {
			SerieResponse response=new SerieResponse();
			BeanUtils.copyProperties(serieDto, response);
			
			serresp.add(response);
		}
		return serresp;
	}
	
	@PutMapping(path = "/{id}")
	public SerieResponse Update(@PathVariable String id,@RequestBody SerieRequest request) {
		SerieDto dto=new SerieDto();
		BeanUtils.copyProperties(request, dto);
		
		SerieDto dto2=service.Update(id, dto);
		SerieResponse response=new SerieResponse();
		
		BeanUtils.copyProperties(dto2, response);
		
		return response; 
	}
	
	@DeleteMapping(path = "/{id}")
	public void Delete(@PathVariable String id) {
		service.Delete(id);
	}
}
