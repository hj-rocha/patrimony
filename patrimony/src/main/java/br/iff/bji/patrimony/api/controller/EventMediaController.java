package br.iff.bji.patrimony.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.iff.bji.patrimony.api.entity.EventMedia;
import br.iff.bji.patrimony.api.service.EventMediaService;

@RestController
public class EventMediaController {
	@Autowired
	private EventMediaService eventMediaService;
	
	@RequestMapping(value = "createeventmedia", method = RequestMethod.POST)
	public String createEventMedia(@RequestBody EventMedia eventMedia) {
		return eventMediaService.createEventMedia(eventMedia);
	}
	
	@RequestMapping(value = "readeventsmedias", method = RequestMethod.GET)
	public List<EventMedia> readEventsMedias(){
		return eventMediaService.readEventsMedias();
	}
	
	@RequestMapping(value = "updateeventmedia", method = RequestMethod.PUT)
	public String updateEventMedia(@RequestBody EventMedia eventMedia) {
		return eventMediaService.updateEventMedia(eventMedia);
	}
	
	@RequestMapping(value = "deleteeventmedia", method = RequestMethod.DELETE)
	public String deleteEventMedia(@RequestBody EventMedia eventMedia) {
		return eventMediaService.updateEventMedia(eventMedia);
	}
}
