package com.raghavrs.springcrudsample.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.raghavrs.springcrudsample.model.Country;

@Service
public class CountryService {
	
	public static List<Country> countryList = new ArrayList<Country>();
	
	static {
		countryList.add(new Country(1, "Ind", 200l));
		countryList.add(new Country(2, "Pak", 200l));
		countryList.add(new Country(3, "Aus", 200l));
		countryList.add(new Country(4, "SL", 200l));
	}

//	@Autowired
//	CountryDAO countryDao;

//	@Transactional
	public List<Country> getAllCountries() {
		return countryList;
		
//		return countryDao.getAllCountries();
	}

//	@Transactional
	public Country getCountry(int id) {
		return countryList.get(id-1);
	}

//	@Transactional
	public void addCountry(Country country) {
		if (country.getId() == 0) {
		country.setId(countryList.size()+1);
		countryList.add(country);
		}else {
			countryList.get(country.getId()-1).setCountryName(country.getCountryName());
			countryList.get(country.getId()-1).setPopulation(country.getPopulation());
		}
	}

//	@Transactional
//	public void updateCountry(Country country) {
//		countryDao.updateCountry(country);
//
//	}

//	@Transactional
	public void deleteCountry(int id) {
		countryList.remove(id-1);
	}
}
