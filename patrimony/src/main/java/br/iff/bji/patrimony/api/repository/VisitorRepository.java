package br.iff.bji.patrimony.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.iff.bji.patrimony.api.entity.Question;
import br.iff.bji.patrimony.api.entity.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

    public boolean existsByCPF(String cpf);

    public List<Visitor> findByCPF(String cpf);

    @Query("select max(v.id) from Visitor v")
    public Integer findMaxId();
}
