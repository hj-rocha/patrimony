package br.iff.bji.patrimony.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EventMedia {
	@Id
	int id;
	
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;
	
	@ManyToOne
	@JoinColumn(name = "media_id")
	private Media media;
	
	public EventMedia() {
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Event getEvent() {
		return this.event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Media getMedia() {
		return this.media;
	}
	
	public void setMedia(Media media) {
		this.media = media;
	}
	
	@Override
	public String toString() {
		return "EventMedia{"+
				"id="+id+
				", event='"+event+
				", media='"+media+'\''+
				'}';
	}
}
