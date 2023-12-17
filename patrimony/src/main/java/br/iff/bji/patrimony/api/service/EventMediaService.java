package br.iff.bji.patrimony.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iff.bji.patrimony.api.entity.Event;
import br.iff.bji.patrimony.api.entity.EventMedia;
import br.iff.bji.patrimony.api.entity.Media;
import br.iff.bji.patrimony.api.entity.Patrimony;
import br.iff.bji.patrimony.api.repository.EventMediaRepository;

@Service
public class EventMediaService {

	@Autowired
	private EventMediaRepository eventMediaRepository;

	@Transactional
	public String createEventMedia(EventMedia eventMedia) {
	    try {
	        if (!eventMediaRepository.existsByEventAndMedia(eventMedia.getEvent(), eventMedia.getMedia())) {
	            eventMedia.setId(null == eventMediaRepository.findMaxId() ? 1 : eventMediaRepository.findMaxId() + 1);
	            eventMediaRepository.save(eventMedia);
	            
	            return "EventMedia record created successfully.";
	        } else {
	            return "EventMedia association already exists in the database.";
	        }
	    } catch (Exception e) {
	        throw e;
	    }
	}


	public List<EventMedia> readEventsMedias() {
		return eventMediaRepository.findAll();
	}

	@Transactional
	public String updateEventMedia(EventMedia updatedEventMedia) {
		try {
			EventMedia existingEventMedia = eventMediaRepository.findById(updatedEventMedia.getId()).orElse(null);
			
			if(existingEventMedia == null) {
				return "EventMedia not found with id:" + updatedEventMedia.getId();
			}
			
			Event updatedEvent = updatedEventMedia.getEvent();
			Media updatedMedia = updatedEventMedia.getMedia();
			if(!eventMediaRepository.existsByEventAndMedia(updatedEventMedia.getEvent(), updatedEventMedia.getMedia())) {
				return "Cannot update EventMedia. Another Type";
			}
			
			existingEventMedia.setEvent(updatedEvent);
			existingEventMedia.setMedia(updatedMedia);
			eventMediaRepository.save(existingEventMedia);
			
			return "EventMedia updated successfully.";
			
		} catch(Exception e) {
			throw e;
		}
	}

	@Transactional
	public String deleteEventMedia(EventMedia eventMedia) {
			try {
				eventMediaRepository.deleteById(eventMedia.getId());
				return "EventMedia record deleted successfully.";
			} catch (Exception e) {
				throw e;
			}

	}
}
