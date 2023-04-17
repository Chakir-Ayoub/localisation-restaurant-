package com.example.demo.service;

import java.util.List;

import com.example.demo.shared.dto.PhotoDto;

public interface PhotoService {
		PhotoDto CreatePhoto(PhotoDto photDto);
		PhotoDto GetAllbyUrl(String url);
		PhotoDto Update(String id,PhotoDto dto);
		void Delete(String id);
		List<PhotoDto> GetAllPhoto();
}
