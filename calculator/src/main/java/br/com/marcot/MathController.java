package br.com.marcot;


import br.com.marcot.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Teste Calculadora
 */
@RestController
public class MathController {

     @RequestMapping(value ="/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
         if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
           throw new UnsuportedMathOperationException("Please set a numeric value!");
         }
         Double sum = converterToDouble(numberOne) + converterToDouble(numberTwo);
         return sum;
    }

    @RequestMapping(value ="/subtraction/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne,
                      @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        Double subtraction = converterToDouble(numberOne) - converterToDouble(numberTwo);
        return subtraction;
    }

    @RequestMapping(value ="/multiplication/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        Double multiplication = converterToDouble(numberOne) * converterToDouble(numberTwo);
        return multiplication;
    }
    @RequestMapping(value ="/division/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne,
                                 @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        Double division = converterToDouble(numberOne) / converterToDouble(numberTwo);
        return division;
    }

    @RequestMapping(value ="/mean/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double mean(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        Double mean = (converterToDouble(numberOne) + converterToDouble(numberTwo))/2;
        return mean;
    }

    @RequestMapping(value ="/squareRoot/{number}",method=RequestMethod.GET)
    public Double  squareRoot(@PathVariable("number") String number) throws Exception {
        if(!isNumeric(number)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        Double  squareRoot = Math.sqrt(converterToDouble(number));
        return  squareRoot;
    }

    private Double converterToDouble(String strNumber) {
        if (Objects.isNull(strNumber)) return 0d;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0d;
    }

    private boolean isNumeric(String strNumber) {
         if(Objects.isNull(strNumber)) return false;
         String number = strNumber.replace(",",".");
         return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
