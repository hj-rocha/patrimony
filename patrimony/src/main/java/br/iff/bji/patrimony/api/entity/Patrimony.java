package br.iff.bji.patrimony.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patrimony {

	
	
	@Id
	private int id;
    
    private String name;
    
    private String country;
    
    private String state;
    
    private String city;
    
    private String description;
    
	@Column(nullable = true)
    private int UNESCOClassification;

	@ManyToOne
	@JoinColumn(name = "typeOfSimplePatrimony_id")
	private TypeOfSimplePatrimony typeOfSimplePatrimony;

    public Patrimony() {
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

	public TypeOfSimplePatrimony getTypeOfSimplePatrimony() {
		return typeOfSimplePatrimony;
	}

	public void setTypeOfSimplePatrimony(TypeOfSimplePatrimony typeOfSimplePatrimony) {
		this.typeOfSimplePatrimony = typeOfSimplePatrimony;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUNESCOClassification() {
		return UNESCOClassification;
	}

	public void setUNESCOClassification(int uNESCOClassification) {
		UNESCOClassification = uNESCOClassification;
	}

	@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
            ", name='" + name + '\'' +
                '}';
    }
}
