package com.example.demo.shared.dto;

import java.io.Serializable;

public class SpecialiteDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8327333817851503428L;
	private Integer id;
	private String specialiteid;
	private String nom;
	public String getSpecialiteid() {
		return specialiteid;
	}
	public void setSpecialiteid(String specialiteid) {
		this.specialiteid = specialiteid;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	
}
