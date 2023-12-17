package br.iff.bji.patrimony.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.iff.bji.patrimony.api.entity.Event;
import br.iff.bji.patrimony.api.entity.EventMedia;
import br.iff.bji.patrimony.api.entity.Media;

public interface EventMediaRepository extends JpaRepository<EventMedia, Integer>{
	public boolean existsByEventAndMedia(Event event, Media media);
	public boolean existsByEvent(Event event);
	public boolean existsByMedia(Media media);
	
	public List<Media> findByMedia(Media media);
	public List<Event> findByEvent(Event event);
	
	@Query("select max(m.id) from Media m")
	public Integer findMaxId();
}
