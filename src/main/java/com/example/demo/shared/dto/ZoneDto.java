package com.example.demo.shared.dto;

import java.io.Serializable;

import com.example.demo.entity.Ville;

public class ZoneDto implements Serializable {
	private static final long serialVersionUID = -4280991494692306627L;
	private String zoneid;
	private String nom;
	private Ville ville;
	
	
	public String getZoneid() {
		return zoneid;
	}
	public void setZoneid(String zoneid) {
		this.zoneid = zoneid;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
	
}
