package br.iff.bji.patrimony.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.iff.bji.patrimony.api.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    public boolean existsByDescription(String description);

    public List<Question> findByDescription(String description);

    @Query("select max(q.id) from Question q")
    public Integer findMaxId();
}
