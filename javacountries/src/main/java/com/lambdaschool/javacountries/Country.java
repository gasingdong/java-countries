package com.lambdaschool.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {

  private static final AtomicLong maxId = new AtomicLong();

  private long id;
  private String name;
  private int population;
  private int size;
  private int medianAge;

  public Country(String name, int population, int size, int medianAge) {
    this.id = maxId.incrementAndGet();
    this.name = name;
    this.population = population;
    this.size = size;
    this.medianAge = medianAge;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getMedianAge() {
    return medianAge;
  }

  public void setMedianAge(int medianAge) {
    this.medianAge = medianAge;
  }

  @Override
  public String toString() {
    return "Country{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", population=" + population +
        ", size=" + size +
        ", medianAge=" + medianAge +
        '}';
  }
}
