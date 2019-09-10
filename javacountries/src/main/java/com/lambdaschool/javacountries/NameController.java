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
@RequestMapping("/names")
public class NameController {

  @GetMapping(value = "/all", produces = {"application/json"})
  public ResponseEntity<?> getAllCountries() {
    List<Country> countries = JavaCountriesApplication.countryList.getCountries();
    countries.sort(Comparator.comparing(Country::getName));
    return new ResponseEntity<>(countries, HttpStatus.OK);
  }

  @GetMapping(value = "/start/{letter}", produces = {"application/json"})
  public ResponseEntity<?> getCountriesStartingWith(@PathVariable char letter) {
    List<Country> countries = JavaCountriesApplication.countryList
        .findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
    countries.sort(Comparator.comparing(Country::getName));
    return new ResponseEntity<>(countries, HttpStatus.OK);
  }

  @GetMapping(value = "/size/{number}", produces = {"application/json"})
  public ResponseEntity<?> getCountryNamesWithLength(@PathVariable int number) {
    List<Country> countries = JavaCountriesApplication.countryList
        .findCountries(c -> c.getName().length() >= number);
    countries.sort(Comparator.comparing(Country::getName));
    return new ResponseEntity<>(countries, HttpStatus.OK);
  }
}
