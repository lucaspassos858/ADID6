package br.edu.ifsp.PersonServices;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

import br.edu.ifsp.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person create (Person person) {
		
		
		return person;
	}
	
	
	public Person update(Person person) {
		
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Lucas Passos");
		person.setLastName("Passos");
		person.setAddress("Rua das rosas 616");
		person.setGender("Male");
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0 ; i < 10; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Nome: "+i);
		person.setLastName("Sobrenome: "+i);
		person.setAddress("Endereço: "+i);
		person.setGender("Sexo: "+i);
		return person;
	}
	
	

}
