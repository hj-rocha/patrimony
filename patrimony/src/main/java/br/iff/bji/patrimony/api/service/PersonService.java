package br.iff.bji.patrimony.api.service;

import br.iff.bji.patrimony.api.entity.Person;
import br.iff.bji.patrimony.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public String createPerson(Person person){
        try {
            if (!personRepository.existsByName(person.getName())){
                person.setId(null == personRepository.findMaxId()? 0 : personRepository.findMaxId() + 1);
                personRepository.save(person);
                return "Person record created successfully.";
            }else {
                return "Person already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public List<Person> readPersons(){
        return personRepository.findAll();
    }

    @Transactional
    public String updatePerson(Person person){
        if (personRepository.existsByName(person.getName())){
            try {
                List<Person> persons = personRepository.findByName(person.getName());
                persons.stream().forEach(s -> {
                    Person pesonToBeUpdate = personRepository.findById(s.getId()).get(s.getId());
                    pesonToBeUpdate.setName(person.getName());
                    pesonToBeUpdate.setName(person.getName());
                    personRepository.save(pesonToBeUpdate);
                });
                return "Person record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Person does not exists in the database.";
        }
    }

    @Transactional
    public String deletePersonByName(Person person){
        if (personRepository.existsByName(person.getName())){
            try {
                List<Person> persons = personRepository.findByName(person.getName());
                persons.stream().forEach(s -> {
                    personRepository.delete(s);
                });
                return "Person record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Person does not exist";
        }
    }
    @Transactional
    public String deletePersonById(Person person){
        if (personRepository.existsById(person.getId())){
            try {
                List<Person> persons = personRepository.findById(person.getId());
                persons.stream().forEach(s -> {
                    personRepository.delete(s);
                });
                return "Person record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Person does not exist";
        }
    }
}
