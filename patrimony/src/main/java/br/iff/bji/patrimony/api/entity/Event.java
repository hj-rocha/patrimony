package br.iff.bji.patrimony.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event {
	@Id
	private int id;
	
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "typeOfEvent_id")
	private TypeOfEvent typeOfEvent;
	
	public Event() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setTypeOfEvent(TypeOfEvent typeOfEvent) {
		this.typeOfEvent = typeOfEvent;
	}
	
	public TypeOfEvent getTypeOfEvent() {
		return this.typeOfEvent;
	}
	
	@Override
	public String toString() {
        return "Student{" +
                "id=" + this.id +
                ", name='" + this.name +
                ", description='" + this.description + '\'' +
                '}';
	}
	
}
