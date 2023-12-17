package br.iff.bji.patrimony.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.iff.bji.patrimony.api.entity.Media;
import br.iff.bji.patrimony.api.entity.Patrimony;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer> {

    public boolean existsByNameOfFile(String nameOfFile);
    public boolean existsByDescription(String description);
    public boolean existsByExtension(String extension);

    public List<Media> findByNameOfFile(String name);
    
    
    @Query("select max(m.id) from Media m")
    public Integer findMaxId();
}
