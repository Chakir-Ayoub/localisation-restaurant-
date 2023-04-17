package com.example.demo.controller;


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

import com.example.demo.reponse.ZoneResponse;
import com.example.demo.request.ZoneRequest;
import com.example.demo.service.ZoneService;
import com.example.demo.shared.dto.ZoneDto;


@RestController
@RequestMapping("/zone")
public class ZoneController {
	
	@Autowired
	ZoneService zoneservice;

	
	@PostMapping()
	public ZoneResponse Save(@RequestBody ZoneRequest zonerequest) {
		ZoneDto zonDto=new ZoneDto();
		BeanUtils.copyProperties(zonerequest, zonDto);
		
		ZoneDto createzone=zoneservice.CreateZone(zonDto);
		ZoneResponse zoneresponse=new ZoneResponse();
		BeanUtils.copyProperties(createzone, zoneresponse);
		return zoneresponse;
	}
	
	@GetMapping(path =  "/{nom}")
	public ZoneResponse getByZoneid(@PathVariable String nom){

		ZoneDto dto=zoneservice.GetBynom(nom);
		ZoneResponse zoneResponse=new ZoneResponse();
		BeanUtils.copyProperties(dto, zoneResponse);
		
		return zoneResponse;
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<ZoneResponse> Update(@PathVariable String id,@RequestBody ZoneRequest request) throws Exception{
		
		ZoneDto dto=new ZoneDto();
		
		BeanUtils.copyProperties(request, dto);
		
		ZoneDto dto2=zoneservice.Update(id, dto);
		ZoneResponse response=new ZoneResponse();
		
		BeanUtils.copyProperties(dto2, response);
		
		return new ResponseEntity<ZoneResponse>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> Delete(@PathVariable String id){
		zoneservice.Delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
