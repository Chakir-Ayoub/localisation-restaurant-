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

import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.reponse.VilleResponse;
import com.example.demo.reponse.ZoneResponse;
import com.example.demo.repository.ZoneRepositoy;
import com.example.demo.request.ZoneRequest;
import com.example.demo.service.ZoneService;
import com.example.demo.shared.dto.ZoneDto;


@RestController
@RequestMapping("/zone")
@CrossOrigin("http://localhost:3000/")
public class ZoneController {
	
	@Autowired
	ZoneService zoneservice;
	@Autowired
	ZoneRepositoy repositoy;
	
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
	
	@GetMapping
	public ResponseEntity<List<ZoneResponse>> GetAll(){
		List<ZoneResponse> zoneResponses=new ArrayList<>();
		List<ZoneDto> dtos=zoneservice.GetAllZone();
		
		for (ZoneDto zoneDto : dtos) {
			ZoneResponse response=new ZoneResponse();
			BeanUtils.copyProperties(zoneDto, response);
			
			zoneResponses.add(response);
		}
		
		return new ResponseEntity<List<ZoneResponse>>(zoneResponses,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("Byid/{id}")
	public ZoneResponse GetById(@PathVariable String id) {
		Zone zone=repositoy.findByzoneid(id);
		ZoneResponse response=new ZoneResponse();
		BeanUtils.copyProperties(zone, response);
		return response;
	}
	

}
