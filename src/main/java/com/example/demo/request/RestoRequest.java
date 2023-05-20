package com.example.demo.request;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Photo;
import com.example.demo.entity.Serie;
import com.example.demo.entity.Zone;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class RestoRequest {
	private String nom;
	private String restoid;
	private Integer rank;
	private String adresse;
	private Integer latitude;
	private Integer longitude;
	@Temporal(TemporalType.TIME)
	private Date heure_open;
	@Temporal(TemporalType.TIME)

	private Date heure_close;
	private String week;
	private Zone zone;
	private Serie serie;
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

	
}
