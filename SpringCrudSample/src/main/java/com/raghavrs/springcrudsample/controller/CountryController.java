package com.raghavrs.springcrudsample.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raghavrs.springcrudsample.model.Country;
import com.raghavrs.springcrudsample.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	CountryService countryService;

	@RequestMapping(value = "/getAllCountries", method = RequestMethod.GET)
	public String getCountries(Model model) {

		List<Country> listOfCountries = countryService.getAllCountries();
		model.addAttribute("country", new Country());
		model.addAttribute("listOfCountries", listOfCountries);
		return "countryDetails";
	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.POST)
	public String addCountry(//@Valid 
			@ModelAttribute("country") Country country, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			bindingResult.resolveMessageCodes("Error message only");
			System.out.println(bindingResult.getAllErrors().toString()); 
			return "countryDetails";
		}

		countryService.addCountry(country);
		
//		if (country.getId() == 0) {
//			countryService.addCountry(country);
//		} else {
//			countryService.updateCountry(country);
//		}

		return "redirect:/getAllCountries";
	}

	@RequestMapping(value = "/updateCountry/{id}", method = RequestMethod.GET)
	public String updateCountry(@PathVariable("id") String id, Model model) {
		model.addAttribute("country", this.countryService.getCountry(Integer.parseInt(id)));
		model.addAttribute("listOfCountries", this.countryService.getAllCountries());
		return "countryDetails";
	}

	@RequestMapping(value = "/deleteCountry/{id}", method = RequestMethod.GET)
	public String deleteCountry(@PathVariable("id") String id) {
		countryService.deleteCountry(Integer.parseInt(id));
		return "redirect:/getAllCountries";

	}
	
}
