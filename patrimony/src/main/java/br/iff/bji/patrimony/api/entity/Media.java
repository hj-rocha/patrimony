package br.iff.bji.patrimony.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Media {
	@Id
	private int id;
	
	private String description;
	
	private String nameOfFile;
	
	private String extension;
	
	public Media() {
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setNameOfFile(String nameOfFile) {
		this.nameOfFile = nameOfFile;
	}
	
	public String getNameOfFile() {
		return this.nameOfFile;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getExtension() {
		return this.extension;
	}	
}
