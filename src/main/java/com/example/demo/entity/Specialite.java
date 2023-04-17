package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


@Entity
public class Specialite  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String specialiteid;
	@Column(nullable = false,length = 50)
	private String nom;
    
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "specialite_resto",joinColumns={@JoinColumn(name="spedialite_id")},inverseJoinColumns = {@JoinColumn(name="resto_id")})
	private Set<Resto> resto=new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

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

	public Set<Resto> getResto() {
		return resto;
	}

	public void setResto(Set<Resto> resto) {
		this.resto = resto;
	}
	
	
}
