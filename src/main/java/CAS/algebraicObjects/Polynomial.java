package CAS.algebraicObjects;

import CAS.parser.PolynomialParser;

import java.util.Arrays;
import java.util.HashMap;

/**
 * A class to represent the polynomial. It supports methods for accessing polynomials, however the actual logic of the
 * computation of polynomials, including their roots and the associated arithmetic is stored in the
 * <code>PolynomialOperations</code> class.
 *
 * See <a href="https://en.wikipedia.org/wiki/Polynomial">Polynomial</a>
 *
 * @see CAS.operations.PolynomialOperations
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class Polynomial{

    private final HashMap<Integer, Double> coefficients;
    private final int maxDegree;

    private Polynomial(int maxDegree, HashMap<Integer, Double> coefficients){
        this.coefficients = coefficients;
        this.maxDegree = maxDegree;
    }

    /**
     * Returns the value of the coefficient of the term with the associate degree in the polynomial, or 0 if the term
     * does not exist in the polynomial.
     *
     * @param degree The degree of the associated term.
     * @return The coefficient of the term with the degree of the argument.
     */
    public double getCoefficient(int degree){
        Double coefficient = coefficients.get(degree);
        if(coefficient == null){
            return 0;
        }

        return coefficient;
    }

    /**
     * Sets the coefficient of the term with the associated degree in the polynomial or if the term does not exist, adds
     * a term with the associated degree and coefficient in the polynomial.
     *
     * @param degree The degree of the associated term.
     * @param coefficient The coefficient of the associated term.
     */
    public void setCoefficient(int degree, double coefficient){
        if(coefficients.containsKey(degree)){
            coefficients.replace(degree, coefficient);
        } else {
            coefficients.put(degree, coefficient);
        }
    }

    /**
     * Removes the term with the associated degree in the polynomial, if it exists.
     *
     * @param degree The degree of the associated term.
     */
    public void removeTerm(int degree){
        coefficients.remove(degree);
    }

    /**
     * Returns the degree of the polynomial.
     *
     * @return The degree of the polynomial.
     */
    public int getPolynomialDegree(){
        return maxDegree;
    }

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
     * @param input The string representation of the polynomial.
     * @return A polynomial object representing the polynomial in question.
     */
    public static Polynomial generateObject(String input) {
        PolynomialParser parser = new PolynomialParser();
        parser.parse(input);
        HashMap<Integer, Double> map = parser.getRepresentation();

        Integer[] arr = new Integer[map.keySet().size()];
        map.keySet().toArray(arr);
        Arrays.sort(arr);

        return new Polynomial(arr[arr.length - 1], map);
    }

}
