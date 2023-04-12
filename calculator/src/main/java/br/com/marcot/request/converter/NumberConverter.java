package br.com.marcot.request.converter;

import java.util.Objects;

public class NumberConverter {

    public static Double covertToDouble(String strNumber) {
        if (Objects.isNull(strNumber)) return 0d;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0d;
    }

    public static boolean isNumeric(String strNumber) {
        if(Objects.isNull(strNumber)) return false;
        String number = strNumber.replace(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
