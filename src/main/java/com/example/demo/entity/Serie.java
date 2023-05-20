package com.example.demo.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name = "serie")
public class Serie  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String serieid;
	@Column(nullable = false,length = 50)
	private String nom;
	
	@JsonIgnore
	 @OneToMany(mappedBy = "id")
	 private java.util.List<Resto> resto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getSerieid() {
		return serieid;
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

	public java.util.List<Resto> getResto() {
		return resto;
	}

	public void setResto(java.util.List<Resto> resto) {
		this.resto = resto;
	}


	

}
