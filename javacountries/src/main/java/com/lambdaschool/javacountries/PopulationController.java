package com.lambdaschool.javacountries;

import java.util.Comparator;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/population")
public class PopulationController {

  @GetMapping(value = "/size/{people}", produces = {"application/json"})
  public ResponseEntity<?> getCountriesWithPopulation(@PathVariable int people) {
    List<Country> countries = JavaCountriesApplication.countryList
        .findCountries(c -> c.getPopulation() >= people);
    return new ResponseEntity<>(countries, HttpStatus.OK);
  }

  @GetMapping(value = "/min", produces = {"application/json"})
  public ResponseEntity<?> getCountryWithSmallestPop() {
    List<Country> countries = JavaCountriesApplication.countryList.getCountries();
    Country smallest = countries.get(0);

    for (int i = 1; i < countries.size(); i++) {
      Country country = countries.get(i);

      if (country.getPopulation() < smallest.getPopulation()) {
        smallest = country;
      }
    }

    return new ResponseEntity<>(smallest, HttpStatus.OK);
  }

  @GetMapping(value = "/max", produces = {"application/json"})
  public ResponseEntity<?> getCountryWithLargestPop() {
    List<Country> countries = JavaCountriesApplication.countryList.getCountries();
    Country largest = countries.get(0);

    for (int i = 1; i < countries.size(); i++) {
      Country country = countries.get(i);

      if (country.getPopulation() > largest.getPopulation()) {
        largest = country;
      }
    }

    return new ResponseEntity<>(largest, HttpStatus.OK);
  }

  @GetMapping(value = "/median", produces = {"application/json"})
  public ResponseEntity<?> getCountryWithMedianPop() {
    List<Country> countries = JavaCountriesApplication.countryList.getCountries();
    countries.sort(Comparator.comparingInt(Country::getPopulation));
    return new ResponseEntity<>(countries.get(countries.size() / 2), HttpStatus.OK);
  }
}
