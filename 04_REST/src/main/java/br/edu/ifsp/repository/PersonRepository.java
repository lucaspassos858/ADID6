package br.edu.ifsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
