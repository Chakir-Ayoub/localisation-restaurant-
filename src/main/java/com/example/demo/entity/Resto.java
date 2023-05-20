package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "resto")
public class Resto  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,length = 50)
	private String nom;
	@Column(nullable = false,length = 50)
	private String restoid;
	@Column(nullable = false)
	private Integer rank;
	@Column(nullable = false,length = 80)
	private String adresse;
	@Column(nullable = false)
	private Integer latitude;
	@Column(nullable = false)
	private Integer longitude;
	@Temporal(TemporalType.TIME)
	private Date heure_open;
	@Temporal(TemporalType.TIME)
	private Date heure_close;
	@Column(nullable = false,length = 80)
	private String week;
	
	@JoinColumn(name = "id_zone",nullable = false)
	@ManyToOne
	private Zone zone;
	
	@JsonIgnore
	@ManyToOne
	private Serie serie;

	
	
	@JsonIgnore
	@OneToMany(mappedBy = "resto",fetch = FetchType.EAGER)
	private List<Photo> photo;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL ,mappedBy = "resto")
	private Set<Specialite> specialite = new HashSet<>();

	public Resto(String restoid, String nom, Integer rank, String adresse, Integer latitude, Integer longitude, Date heure_open, Date heure_close, String week, Zone zone, Serie serie, List<Photo> photo, Set<Specialite> specialite) {
	    this.restoid = restoid;
	    this.nom = nom;
	    this.rank = rank;
	    this.adresse = adresse;
	    this.latitude = latitude;
	    this.longitude = longitude;
	    this.heure_open = heure_open;
	    this.heure_close = heure_close;
	    this.week = week;
	    this.zone = zone;
	    this.serie = serie;
	    this.photo = photo;
	    this.specialite = specialite;
	}

	public Resto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public String getRestoid() {
		return restoid;
	}

	public void setRestoid(String restoid) {
		this.restoid = restoid;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Integer getLatitude() {
		return latitude;
	}

	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}

	public Integer getLongitude() {
		return longitude;
	}

	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}

	public Date getHeure_open() {
		return heure_open;
	}

	public void setHeure_open(Date heure_open) {
		this.heure_open = heure_open;
	}

	public Date getHeure_close() {
		return heure_close;
	}

	public void setHeure_close(Date heure_close) {
		this.heure_close = heure_close;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public Set<Specialite> getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Set<Specialite> specialite) {
		this.specialite = specialite;
	}

	
}
