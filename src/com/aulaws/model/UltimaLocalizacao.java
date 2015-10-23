package com.aulaws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="last_location")
@NamedQueries({ 
@NamedQuery(name="location.ultimaLocalizacao", 
			query="select max(c.codigo), latitude, longitude from UltimaLocalizacao c")})
public class UltimaLocalizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "las_id")
	int codigo;

	@Column(name = "las_latitude")
	double latitude;

	@Column(name = "las_longitude")
	double longitude;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "UltimaLocalizacao [codigo=" + codigo + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

	
	
}
