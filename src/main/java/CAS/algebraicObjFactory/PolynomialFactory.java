package CAS.algebraicObjFactory;

import CAS.algebraicObjects.Polynomial;
import CAS.parser.PolynomialParser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * The grammar defined for the string representation for a polynomial is as follows:
 *      15x^4 + 12x^3 + 9x^2 + 6x + 3
 * Where each of the x-terms are representative of the term in the polynomial of that degree. The coefficients are
 * always in the front, and the polynomial is always represented in the form shown above. Although, terms that have a
 * leading coefficient of 1 need not include the actual coefficient, as is convention. Also, any term that has a 0
 * coefficient need not be included, as also is convention. Addition is commutative and associative, the terms can
 * also be written in any order, as it is mathematically accurate.
 *
 * @see CAS.parser.PolynomialParser
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class PolynomialFactory{
    static Polynomial generateObject(String input) {
        PolynomialParser parser = new PolynomialParser();
        parser.parse(input);
        HashMap<Integer, Double> map = parser.getRepresentation();

        return new Polynomial(getPolynomialDegree(map.keySet()), map);
    }

    private static int getPolynomialDegree(Set<Integer> degrees){
        Integer[] arr = new Integer[degrees.size()];
        degrees.toArray(arr);
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}
