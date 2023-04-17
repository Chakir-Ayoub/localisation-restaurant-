package com.example.demo.request;

import com.example.demo.entity.Ville;


public class ZoneRequest {
	private String nom;
	private Ville ville;
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
