package com.example.demo.entity;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "zone")
public class Zone  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String zoneid;


	@Column(nullable = false,length = 50)
	private String nom;
	
	@JoinColumn(name = "ville")
	@ManyToOne
	private Ville ville;

	@JsonIgnore
	@OneToMany(mappedBy = "zone",fetch = FetchType.EAGER)
	private List<Resto> resto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



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

	public List<Resto> getResto() {
		return resto;
	}

	public void setResto(List<Resto> resto) {
		this.resto = resto;
	}

	public Zone(String json) throws JsonParseException, JsonMappingException, IOException {
	    ObjectMapper mapper = new ObjectMapper();
	    Zone zone = mapper.readValue(json, Zone.class);
	    this.id = zone.getId();
	    this.zoneid = zone.getZoneid();
	    this.nom = zone.getNom();
	    this.ville = zone.getVille();
	    this.resto = zone.getResto();
	}

	public Zone() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
	
	
}
