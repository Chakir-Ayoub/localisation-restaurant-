package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Resto;
import com.example.demo.reponse.RestoResponse;
import com.example.demo.request.RestoRequest;
import com.example.demo.service.RestoService;
import com.example.demo.shared.dto.RestoDto;

@RestController
@RequestMapping("/resto")
@CrossOrigin("http://localhost:3000/")
public class RestoController {
	
	@Autowired 
	RestoService restoService;
	@PostMapping
	public RestoResponse Save(@RequestBody RestoRequest request) {
		RestoDto dto=new RestoDto();
		BeanUtils.copyProperties(request, dto);
		
		RestoDto createResto=restoService.CreateResto(dto);
		RestoResponse response=new RestoResponse();
		BeanUtils.copyProperties(createResto, response);
		
		return response;
	}
	
	@GetMapping(path = "/{nom}")
	public RestoResponse GetByNom(@PathVariable String nom) {
		RestoDto dto=restoService.GetAllByNom(nom);
		RestoResponse response=new RestoResponse();
		BeanUtils.copyProperties(dto, response);
		
		return response;
	}
	
	
	
	@GetMapping
	public List<RestoResponse> GetAll(){
		List<RestoResponse> list=new ArrayList<>();
		List<RestoDto> dtos=restoService.GetAllResto();
		for (RestoDto restoDto : dtos) {
			RestoResponse response=new RestoResponse();
			BeanUtils.copyProperties(restoDto, response);
			
			list.add(response);
		}
		return list;
	}
	
	@PutMapping(path = "/{id}")
	public RestoResponse Update(@PathVariable String id,@RequestBody RestoRequest request) {
		RestoDto dto=new RestoDto();
		BeanUtils.copyProperties(request, dto);
		
		RestoDto dto2=restoService.Update(id, dto);
		RestoResponse response=new RestoResponse();
		
		BeanUtils.copyProperties(dto2, response);
		
		return response;
	}
	
	@DeleteMapping(path = "/{id}")
	public void Delete(@PathVariable String id) {
		restoService.Delete(id);
	}
	
	
	@GetMapping(path = "/Byid/{id}")
	public ResponseEntity<RestoResponse> GetById(@PathVariable String id){
		RestoDto restoDto=restoService.GetById(id);
		RestoResponse resto=new RestoResponse();
		
		BeanUtils.copyProperties(restoDto, resto);
		
		return new ResponseEntity<>(resto,HttpStatus.OK);
		
		
	}
}
