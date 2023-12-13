package br.iff.bji.patrimony.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeOfEvent {
	@Id
	int id;
	
	String description;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + description + '\'' +
                '}';
	}
}
