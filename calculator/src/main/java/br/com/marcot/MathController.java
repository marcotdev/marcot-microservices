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