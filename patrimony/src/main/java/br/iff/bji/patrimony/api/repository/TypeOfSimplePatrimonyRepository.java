package br.iff.bji.patrimony.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.iff.bji.patrimony.api.entity.Question;
import br.iff.bji.patrimony.api.entity.TypeOfSimplePatrimony;

@Repository
public interface TypeOfSimplePatrimonyRepository extends JpaRepository<TypeOfSimplePatrimony, Integer> {

    public boolean existsByDescription(String description);

    public List<TypeOfSimplePatrimony> findByDescription(String description);

    @Query("select max(tosp.id) from TypeOfSimplePatrimony tosp")
    public Integer findMaxId();
}
