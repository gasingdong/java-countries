package com.lambdaschool.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesApplication {

  static CountryList countryList;

  public static void main(String[] args) {
    countryList = new CountryList();
    SpringApplication.run(JavaCountriesApplication.class, args);
  }
}
