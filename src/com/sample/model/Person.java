package com.sample.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Person {
	private int id; 
	private String name; 
	private String favoriteCity;
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
	public String getFavoriteCity() {
		return favoriteCity;
	}
	public void setFavoriteCity(String favoriteCity) {
		this.favoriteCity = favoriteCity;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", favoriteCity=" + favoriteCity + "]";
	}
	
	
}
