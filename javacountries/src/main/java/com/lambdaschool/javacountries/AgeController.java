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
@RequestMapping("/age")
public class AgeController {

  @GetMapping(value = "/{age}", produces = {"application/json"})
  public ResponseEntity<?> getCountriesWithMedianAge(@PathVariable int age) {
    List<Country> countries = JavaCountriesApplication.countryList
        .findCountries(c -> c.getMedianAge() >= age);
    return new ResponseEntity<>(countries, HttpStatus.OK);
  }

  @GetMapping(value = "/min", produces = {"application/json"})
  public ResponseEntity<?> getCountryWithLowestAge() {
    List<Country> countries = JavaCountriesApplication.countryList.getCountries();
    Country lowest = countries.get(0);

    for (int i = 1; i < countries.size(); i++) {
      Country country = countries.get(i);

      if (country.getMedianAge() < lowest.getMedianAge()) {
        lowest = country;
      }
    }

    return new ResponseEntity<>(lowest, HttpStatus.OK);
  }

  @GetMapping(value = "/max", produces = {"application/json"})
  public ResponseEntity<?> getCountryWithHighestAge() {
    List<Country> countries = JavaCountriesApplication.countryList.getCountries();
    Country largest = countries.get(0);

    for (int i = 1; i < countries.size(); i++) {
      Country country = countries.get(i);

      if (country.getMedianAge() > largest.getMedianAge()) {
        largest = country;
      }
    }

    return new ResponseEntity<>(largest, HttpStatus.OK);
  }

  @GetMapping(value = "/median", produces = {"application/json"})
  public ResponseEntity<?> getCountryWithMedianPop() {
    List<Country> countries = JavaCountriesApplication.countryList.getCountries();
    countries.sort(Comparator.comparingInt(Country::getMedianAge));
    return new ResponseEntity<>(countries.get(countries.size() / 2), HttpStatus.OK);
  }
}
