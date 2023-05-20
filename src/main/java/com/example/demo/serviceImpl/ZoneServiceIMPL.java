package com.example.demo.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepositoy;
import com.example.demo.service.ZoneService;
import com.example.demo.sharedd.Utils;
import com.example.demo.shared.dto.VilleDto;
import com.example.demo.shared.dto.ZoneDto;

@Service
public class ZoneServiceIMPL implements ZoneService {
	
	@Autowired
	ZoneRepositoy zoneRepositoy;
	@Autowired
	Utils utils;
	@Override
	public ZoneDto GetBynom(String nom) {
		Zone zone=zoneRepositoy.findBynom(nom);
		ZoneDto dto=new ZoneDto();
		BeanUtils.copyProperties(zone, dto);
		return dto;
	}

	@Override
	public ZoneDto CreateZone(ZoneDto zone) {
		Zone zo=new Zone();
		BeanUtils.copyProperties(zone, zo);
		
		zo.setZoneid(utils.generateStringId(32));
		
		Zone zonne=zoneRepositoy.save(zo);
		ZoneDto dto=new ZoneDto();
		
		BeanUtils.copyProperties(zonne, dto);
		return dto;
	}

	@Override
	public ZoneDto Update(String id, ZoneDto dto) {
		// TODO Auto-generated method stub
		Zone zone=zoneRepositoy.findByzoneid(id);
		
		zone.setNom(dto.getNom());
		zone.setVille(dto.getVille());
		
		Zone zoneUpdate=zoneRepositoy.save(zone);
		ZoneDto dto2=new ZoneDto();
		BeanUtils.copyProperties(zoneUpdate, dto2);
		return dto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Zone zone=zoneRepositoy.findByzoneid(id);
		
		if(zone==null) throw new RuntimeException("Zone Not exist");
		zoneRepositoy.delete(zone);
		
	}

	@Override
	public List<ZoneDto> GetAllZone() {
		// TODO Auto-generated method stub
		List<ZoneDto> zoneDtos=new ArrayList<>();
		List<Zone> zones=zoneRepositoy.findAll();
		
		for (Zone zone : zones) {
			ZoneDto dto=new ZoneDto();
			BeanUtils.copyProperties(zone, dto);
			
			zoneDtos.add(dto);
		}
		return zoneDtos;
	}

	


}
