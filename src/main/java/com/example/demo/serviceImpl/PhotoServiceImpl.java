package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Photo;
import com.example.demo.repository.PhotoRepository;
import com.example.demo.service.PhotoService;
import com.example.demo.sharedd.Utils;
import com.example.demo.shared.dto.PhotoDto;

@Service
public class PhotoServiceImpl implements PhotoService {
	@Autowired
	PhotoRepository photoRepository;
	@Autowired
	Utils utils;
	@Override
	public PhotoDto CreatePhoto(PhotoDto dto) {
		// TODO Auto-generated method stub
		Photo photo=new Photo();
		BeanUtils.copyProperties(dto, photo);
		photo.setPhotoid(utils.generateStringId(32));
		
		Photo pho=photoRepository.save(photo);
		PhotoDto photoDto=new PhotoDto();
		
		BeanUtils.copyProperties(pho, photoDto);
		return photoDto;
	}

	@Override
	public PhotoDto GetAllbyUrl(String url) {
		// TODO Auto-generated method stub
		Photo photo=photoRepository.findByurl(url);
		PhotoDto dto=new PhotoDto();
		BeanUtils.copyProperties(photo, dto);
		return dto;
	}

	@Override
	public PhotoDto Update(String id, PhotoDto dto) {
		// TODO Auto-generated method stub
		Photo photoid=photoRepository.findByphotoid(id);
		if(photoid==null) throw new RuntimeException("Photo Not Found");
		Photo photo=photoRepository.findByurl(dto.getUrl());
		if(photo!=null) throw new RuntimeException("Photo Already Exists");
		photoid.setUrl(dto.getUrl());
		
		photoRepository.save(photoid);
		PhotoDto dto2=new  PhotoDto();
		BeanUtils.copyProperties(photo, dto2);
		return dto2;
	}

	@Override
	public void Delete(String id) {
		// TODO Auto-generated method stub
		Photo photoid=photoRepository.findByphotoid(id);
		if(photoid==null) throw new RuntimeException("Photo Not Found");
		
		photoRepository.delete(photoid);
	}

	@Override
	public List<PhotoDto> GetAllPhoto() {
		// TODO Auto-generated method stub
		List<PhotoDto> dtos=new ArrayList<>();
		List<Photo> list=photoRepository.findAll();
		
		for (Photo photo : list) {
			PhotoDto dto=new PhotoDto();
			BeanUtils.copyProperties(photo, dto);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public PhotoDto GetAllbyid(String url) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
