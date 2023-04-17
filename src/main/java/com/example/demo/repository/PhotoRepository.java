package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer> {
	Photo findByurl(String url);
	Photo findByphotoid(String photoid);
}
