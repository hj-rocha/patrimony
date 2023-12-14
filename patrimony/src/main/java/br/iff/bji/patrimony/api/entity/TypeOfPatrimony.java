package br.iff.bji.patrimony.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeOfPatrimony {

    @Id
    private int id;

    private String description;

    public TypeOfPatrimony() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
