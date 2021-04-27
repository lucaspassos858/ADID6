package br.edu.ifsp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne,
						@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException
						("Por favor entre com um valor numérico!");
		}
		Double sum = converToDouble(numberOne) + converToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne,
						@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException
						("Por favor entre com um valor numérico!");
		}
		Double sum = converToDouble(numberOne) - converToDouble(numberTwo);
		return sum;
	}
	
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne,
						@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException
						("Por favor entre com um valor numérico!");
		}
		Double sum = converToDouble(numberOne) * converToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne,
						@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException
						("Por favor entre com um valor numérico!");
		}
		Double sum = converToDouble(numberOne) / converToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne,
						@PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedOperationException
						("Por favor entre com um valor numérico!");
		}
		Double sum = (converToDouble(numberOne) + converToDouble(numberTwo))/2;
		return sum;
	}
	
	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if(!isNumeric(number)) {
			throw new UnsupportedOperationException
						("Por favor entre com um valor numérico!");
		}
		Double sum = (Double) Math.sqrt(converToDouble(number));
		return sum;
	}
	
	
	
	private Double converToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number= strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}
	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}