package br.iff.bji.patrimony.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.iff.bji.patrimony.api.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{
	
	public boolean existsByName(String name);
	public boolean existsByDescription(String description);
	
	public List<Event> findByName(String name);
	
	@Query("select max(e.id) from Event e")
	public Integer findMaxId();
}
