package br.iff.bji.patrimony.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    private int id;

    private String description;

    private String isAnswser;

    public Question() {
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

	public String getIsAnswser() {
		return isAnswser;
	}

	public void setIsAnswser(String isAnswser) {
		this.isAnswser = isAnswser;
	}

	@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isAnwser='" + isAnswser + '\'' +
                '}';
    }
}
