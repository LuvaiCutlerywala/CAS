package CAS.algebraicObjFactory;

import CAS.algebraicObjects.Polynomial;

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
    public Polynomial generateObject(String input) {
        return null;
    }
}
