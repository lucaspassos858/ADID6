package br.edu.ifsp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.PersonServices.PersonServices;
import br.edu.ifsp.model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return services.findAll();
	}

	
	@RequestMapping(value="/{id}", method=RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE)

	public Person findById(@PathVariable("id") String id) {
		return services.findById(id);
	}
	
}
