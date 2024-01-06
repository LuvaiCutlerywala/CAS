package CAS.algebraicObjects;

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
public class Polynomial implements AlgebraicObject{

    private final HashMap<Integer, Double> coefficients;
    private final int maxDegree;

    public Polynomial(int maxDegree, HashMap<Integer, Double> coefficients){
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

}
