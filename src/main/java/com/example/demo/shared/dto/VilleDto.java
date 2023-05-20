package com.example.demo.shared.dto;

import java.io.Serializable;

public class VilleDto implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6119546399345933665L;
	private Integer id;
	private String villeid;
	private String nom;
	
	public String getVilleid() {
		return villeid;
	}
	public void setVilleid(String villeid) {
		this.villeid = villeid;
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
