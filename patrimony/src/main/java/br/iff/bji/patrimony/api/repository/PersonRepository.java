package com.pxp.SQLite.demo.repository;

import com.pxp.SQLite.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    public boolean existsByName(String name);
    
    public boolean existsById(int id);

    public List<Person> findByName(String name);
    public List<Person> findById(int id);

    @Query("select max(p.id) from Person p")
    public Integer findMaxId();
}
