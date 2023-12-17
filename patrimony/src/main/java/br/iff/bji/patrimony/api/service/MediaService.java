package br.iff.bji.patrimony.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iff.bji.patrimony.api.entity.Event;
import br.iff.bji.patrimony.api.entity.Media;
import br.iff.bji.patrimony.api.repository.MediaRepository;

@Service
public class MediaService {
	
	@Autowired
	private MediaRepository mediaRepository;
	
	@Transactional
	public String createMedia(Media media) {
		System.out.println(media.getNameOfFile());
		try {
			if(!mediaRepository.existsByNameOfFile(media.getNameOfFile())) {
				media.setId(null == mediaRepository.findMaxId() ? 1 : mediaRepository.findMaxId() + 1);
				mediaRepository.save(media);
				return "Media created successfully.";
			} else {
				return "Media already exist in database.";
			}
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	@Transactional
	public List<Media> readMedias(){
		return mediaRepository.findAll();
	}
	
	@Transactional
	public String updateMedia(Media updatedMedia) {
		try {
			Media existingMedia = mediaRepository.findById(updatedMedia.getId()).orElse(null);
			
			if(existingMedia == null) {
				return "Media not found with id:" + updatedMedia.getId();
			}
			
			String updatedName = updatedMedia.getNameOfFile();
			String updatedDescription = updatedMedia.getDescription();
			String updatedExtension = updatedMedia.getExtension();
			if((!existingMedia.getNameOfFile().equals(updatedName) && mediaRepository.existsByNameOfFile(updatedName)) 
					|| (!existingMedia.getDescription().equals(updatedDescription) && mediaRepository.existsByDescription(updatedDescription))
					|| (!existingMedia.getExtension().equals(updatedExtension) && mediaRepository.existsByExtension(updatedExtension))) {
				return "Cannot update Media. Already exists same Name, Extension or Description from Media";
			}
			
			existingMedia.setNameOfFile(updatedName);
			existingMedia.setDescription(updatedDescription);
			existingMedia.setExtension(updatedExtension);
			mediaRepository.save(existingMedia);
			
			return "Media updated successfully.";
			
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional
	public String deleteMedia(Media media) {
		try {
			mediaRepository.deleteById(media.getId());
			return "Media record deleted successfully.";
		} catch (Exception e) {
			throw e;
		}
	}
}
