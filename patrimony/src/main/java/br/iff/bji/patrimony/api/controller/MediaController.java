package br.iff.bji.patrimony.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.iff.bji.patrimony.api.entity.Media;
import br.iff.bji.patrimony.api.service.MediaService;

@RestController
public class MediaController {
	@Autowired
	private MediaService mediaService;
	
	@RequestMapping(value = "createmedia", method = RequestMethod.POST)
	public String createMedia(@RequestBody Media media) {
		return mediaService.createMedia(media);
	}
	
	@RequestMapping(value = "readmedias", method = RequestMethod.GET)
	public List<Media> readMedias() {
		return mediaService.readMedias();
	}
	
	@RequestMapping(value = "updatemedia", method = RequestMethod.PUT)
	public String updateMedia(@RequestBody Media media) {
		return mediaService.updateMedia(media);
	}
	
	@RequestMapping(value = "deletemedia", method = RequestMethod.DELETE)
	public String deleteMedia(@RequestBody Media media) {
		return mediaService.deleteMedia(media);
	}
}
