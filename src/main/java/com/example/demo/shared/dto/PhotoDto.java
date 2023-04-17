package com.example.demo.shared.dto;

import java.io.Serializable;

import com.example.demo.entity.Resto;


public class PhotoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5957944669300135627L;
	private String photoid;
	private String url;
	private Resto resto;
	
	public String getPhotoid() {
		return photoid;
	}
	public void setPhotoid(String photoid) {
		this.photoid = photoid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Resto getResto() {
		return resto;
	}
	public void setResto(Resto resto) {
		this.resto = resto;
	}
	
	
}
