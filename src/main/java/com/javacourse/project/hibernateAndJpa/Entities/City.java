package com.javacourse.project.hibernateAndJpa.Entities;

import javax.persistence.*;

@Entity //bunun bir veritabanı nesnesi olduğunu anlatan annotation.
@Table(name="city") //city nin sahip olduğu attribute lerin table a karşılık geldiğini anlatıp bağlayan annotation.
public class City {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //bu id alanının otomatik artacağını otomatik olarak arttırılacağına dair kullandığımız annotation.
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="countrycode")
	private String countryCode;
	
	@Column(name="district")
	private String district;
	
	@Column(name="population")
	private int population;
	public City(int id, String name, String countryCode, String district, int population) {
		super(); //super() metodu, üst-sınıfa ait bir nesne constructor yerine geçer. Üst-sınıfta overload edilmiş constructorlar tanımlı ise, hangisini çağıracağını, kullanılan parametreler belirler. Çünkü, java derleyicisi overload edilen fonksiyonları, parametreleri yardımıyla birbirinden ayırır.
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	
	public City() {} //hibernate için default constructor.
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
