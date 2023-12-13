package br.iff.bji.patrimony.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.iff.bji.patrimony.api.entity.TypeOfEvent;

public interface TypeOfEventRepository extends JpaRepository<TypeOfEvent, Integer>{ //o que é esse integer??
	
	public boolean existsByDescription(String description);
	
	public List<TypeOfEvent> findByDescription(String description);
	
	@Query("select max(toe.id) from TypeOfEvent toe")
	public Integer findMaxId();
}
