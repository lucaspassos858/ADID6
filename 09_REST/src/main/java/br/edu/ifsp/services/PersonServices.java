package br.edu.ifsp.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.converter.DozerConverter;
import br.edu.ifsp.converter.custom.PersonConverter;
import br.edu.ifsp.data.model.Person;
import br.edu.ifsp.data.vo.PersonVO;
import br.edu.ifsp.data.vo.v2.PersonVOV2;
import br.edu.ifsp.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;
		
	public PersonVO create (PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2 (PersonVOV2 person) {
		var entity = converter.convertVOToEntity(person);
		var vo = converter.convertEntitytoVO(repository.save(entity));
		return vo;
	}
	
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseObjects(repository.findAll(), PersonVO.class);
	}	
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	
	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException
						("ID não encontrado"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException
						("ID não encontrado"));
		repository.delete(entity);
	}
	
	
	
	

}
