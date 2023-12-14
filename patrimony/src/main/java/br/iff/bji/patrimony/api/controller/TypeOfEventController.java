package br.iff.bji.patrimony.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.iff.bji.patrimony.api.entity.TypeOfEvent;
import br.iff.bji.patrimony.api.service.TypeOfEventService;

@RestController
public class TypeOfEventController {
	@Autowired
	private TypeOfEventService typeOfEventService;
	
	@RequestMapping(value = "createtypeofevent", method = RequestMethod.POST)
	public String createTypeOfEvent(@RequestBody TypeOfEvent typeOfEvent) {
		return typeOfEventService.createTypeOfEvent(typeOfEvent);
	}
	
	@RequestMapping(value = "readtypesofevents", method = RequestMethod.GET)
	public List<TypeOfEvent> readTypesOfEvents() {
		return typeOfEventService.readTypesOfEvents();
	}
	
	@RequestMapping(value = "updatetypeofevent", method = RequestMethod.PUT)
	public String updateTypeOfEvent(@RequestBody TypeOfEvent typeOfEvent) {
		return typeOfEventService.updateTypeOfEvent(typeOfEvent);
	}

	@RequestMapping(value = "deletetypeofevent", method = RequestMethod.DELETE)
	public String deleteTypeOfEvent(@RequestBody TypeOfEvent typeOfEvent) {
		return typeOfEventService.deleteTypeOfEvent(typeOfEvent);
	}
}
