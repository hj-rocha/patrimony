package br.iff.bji.patrimony.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.iff.bji.patrimony.api.entity.Question;
import br.iff.bji.patrimony.api.entity.TypeOfPatrimony;

@Repository
public interface TypeOfPatrimonyRepository extends JpaRepository<TypeOfPatrimony, Integer> {

    public boolean existsByDescription(String description);

    public List<TypeOfPatrimony> findByDescription(String description);

    @Query("select max(tosp.id) from TypeOfPatrimony tosp")
    public Integer findMaxId();
}
