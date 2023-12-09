package br.iff.bji.patrimony.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.iff.bji.patrimony.api.entity.Patrimony;

@Repository
public interface PatrimonyRepository extends JpaRepository<Patrimony, Integer> {

    public boolean existsByName(String name);

    public List<Patrimony> findByName(String name);

    @Query("select max(p.id) from Patrimony p")
    public Integer findMaxId();
}
