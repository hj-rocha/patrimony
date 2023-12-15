package com.pxp.SQLite.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    private int id;

    private String name;

    private String biography;
    
    private LocalDate birthday;
    
    private LocalDate deathday;
    
    public Person() {
		
	}
    
    
    
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



	public String getBiography() {
		return biography;
	}



	public void setBiography(String biography) {
		this.biography = biography;
	}



	public LocalDate getBirthday() {
		return birthday;
	}



	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}



	public LocalDate getDeathday() {
		return deathday;
	}



	public void setDeathday(LocalDate deathday) {
		this.deathday = deathday;
	}



	@Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", deathday='" + deathday + '\'' +'}';
    }
}
