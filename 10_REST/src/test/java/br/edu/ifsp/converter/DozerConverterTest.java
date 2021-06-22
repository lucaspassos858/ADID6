package br.edu.ifsp.converter;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifsp.converter.mocks.MockPerson;
import br.edu.ifsp.data.model.Person;
import br.edu.ifsp.data.vo.v1.PersonVO;

import java.util.List;

import org.junit.Assert;

public class DozerConverterTest {
	
	MockPerson inputObject;
	
	@Before
	public void setUp() {
		inputObject = new MockPerson();
	}
	
	@Test
	public void parseEntityToVOTest() {
		PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Primeiro Nome test0", output.getFirstName());
		Assert.assertEquals("Sobrenome test0", output.getLastName());
		Assert.assertEquals("Endereço test0", output.getAddress());
		Assert.assertEquals("Masculino", output.getGender());
		
	}
	
	@Test
	public void parseEntityListToVOTest() {
		List<PersonVO> outputList = DozerConverter.parseObjects(inputObject.mockEntityList(), PersonVO.class);
		
		PersonVO outputZero = outputList.get(0);
		
		Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
		Assert.assertEquals("Primeiro Nome test0", outputZero.getFirstName());
		Assert.assertEquals("Sobrenome test0", outputZero.getLastName());
		Assert.assertEquals("Endereço test0", outputZero.getAddress());
		Assert.assertEquals("Masculino", outputZero.getGender());
		
		
		PersonVO outputSeven = outputList.get(7);
		
		Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
		Assert.assertEquals("Primeiro Nome test7", outputSeven.getFirstName());
		Assert.assertEquals("Sobrenome test7", outputSeven.getLastName());
		Assert.assertEquals("Endereço test7", outputSeven.getAddress());
		Assert.assertEquals("Feminino", outputSeven.getGender());
		
		
		
		PersonVO outputTwelve = outputList.get(12);
		
		Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
		Assert.assertEquals("Primeiro Nome test12", outputTwelve.getFirstName());
		Assert.assertEquals("Sobrenome test12", outputTwelve.getLastName());
		Assert.assertEquals("Endereço test12", outputTwelve.getAddress());
		Assert.assertEquals("Masculino", outputTwelve.getGender());
		
	}
	
	
	@Test
	public void parseEntityTest() {
		Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
		Assert.assertEquals(Long.valueOf(0L), output.getId());
		Assert.assertEquals("Primeiro Nome test0", output.getFirstName());
		Assert.assertEquals("Sobrenome test0", output.getLastName());
		Assert.assertEquals("Endereço test0", output.getAddress());
		Assert.assertEquals("Masculino", output.getGender());
		
	}

}
