package br.edu.ifsp.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.model.Person;
import br.edu.ifsp.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
		
	public Person create (Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException
						("ID not found"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException
						("ID not found"));
		repository.delete(entity);
	}
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("ID not found"));
	}
	
	public List<Person> findAll(){
		return repository.findAll();
	}	

}
