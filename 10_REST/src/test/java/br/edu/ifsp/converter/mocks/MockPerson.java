package br.edu.ifsp.converter.mocks;


import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.data.model.Person;
import br.edu.ifsp.data.vo.v1.PersonVO;

public class MockPerson {

	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonVO mockVO() {
		return mockVO(0);
	}
	
	public List<Person> mockEntityList(){
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}
	
	public List<PersonVO> mockVOList(){
		List<PersonVO> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockVO(i));
		}
		return persons;
	}
	
	private Person mockEntity(Integer number) {
		Person person = new Person();
		person.setAddress("Endereço test" + number);
		person.setFirstName("Primeiro Nome test" + number);
		person.setLastName("Sobrenome test" + number);
		person.setGender(((number % 2)==0) ? "Masculino" : "Feminino");
		person.setId(number.longValue());
		return person;
	}
	
	private PersonVO mockVO(Integer number) {
		PersonVO person = new PersonVO();
		person.setAddress("Endereço test" + number);
		person.setFirstName("Primeiro Nome test" + number);
		person.setLastName("Sobrenome test" + number);
		person.setGender(((number % 2)==0) ? "Masculino" : "Feminino");
		person.setId(number.longValue());
		return person;
	}
}
