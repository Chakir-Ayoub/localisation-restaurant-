package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.reponse.SpecialiteResponse;
import com.example.demo.request.SpecialiteRequest;
import com.example.demo.service.SpecialiteService;
import com.example.demo.shared.dto.SpecialiteDto;

@RestController
@RequestMapping("/specialite")
public class SpecialiteController {
	@Autowired
	SpecialiteService service;
	
	@PostMapping
	public SpecialiteResponse Save(@RequestBody SpecialiteRequest request) {
		SpecialiteDto dto=new SpecialiteDto();
		BeanUtils.copyProperties(request, dto);
		
		SpecialiteDto dto2=service.CreateSpecialite(dto);
		SpecialiteResponse createspecialite= new SpecialiteResponse();
		
		BeanUtils.copyProperties(dto2, createspecialite);
		
		return createspecialite;
	}
	
	@GetMapping(path = "/{nom}")
	public SpecialiteResponse GetByNom(@PathVariable String nom) {
		SpecialiteDto dto=service.GetByNom(nom);
		SpecialiteResponse response=new SpecialiteResponse();
		BeanUtils.copyProperties(dto, response);
		return response;
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<SpecialiteResponse> Update(@PathVariable String id,@RequestBody SpecialiteRequest request) throws Exception{
		SpecialiteDto dto=new SpecialiteDto();
		
		BeanUtils.copyProperties(request, dto);
		
		SpecialiteDto dto2=service.Update(id, dto);
		SpecialiteResponse response=new SpecialiteResponse();
		
		BeanUtils.copyProperties(dto2, response);

		return new ResponseEntity<SpecialiteResponse>(response,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id) {
		service.Delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<List<SpecialiteResponse>> getAll(){
		return null;
		
	}
}
