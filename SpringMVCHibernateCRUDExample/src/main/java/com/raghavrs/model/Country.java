package com.raghavrs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@NotBlank(message = "country name can not be blank")
	@Column(name = "country_name")
	String countryName;

	@Min(value = 1,message = "Population can not be zero")
	@Column(name = "population")
	long population;

	public Country() {
		super();
	}

	public Country(int i, String countryName, long population) {
		super();
		this.id = i;
		this.countryName = countryName;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

}