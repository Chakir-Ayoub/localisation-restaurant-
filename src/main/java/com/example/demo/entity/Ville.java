package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name = "ville")
public class Ville  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String villeid;
	@Column(nullable = false,length = 50)
	private String nom;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ville",fetch = FetchType.EAGER)
	private List<Zone> zone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


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

	public List<Zone> getZone() {
		return zone;
	}

	public void setZone(List<Zone> zone) {
		this.zone = zone;
	}
	
}
