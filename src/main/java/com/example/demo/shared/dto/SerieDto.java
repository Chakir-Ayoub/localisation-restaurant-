package com.example.demo.shared.dto;

import java.io.Serializable;

public class SerieDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6133414157238683570L;
	private Integer id;
	private String serieid;
	private String nom;
	
	public String getSerieid() {
		return serieid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSerieid(String serieid) {
		this.serieid = serieid;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
