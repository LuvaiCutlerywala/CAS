package CAS.parser;

import CAS.algebraicObjects.Polynomial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Extracts the polynomial data from the provided string representation, and then generates a structure
 * preserving object that holds the data before it is passed to associated type of the algebraic object. The grammar for
 * a polynomial string representation is as such:
 *          15x^4 + 12x^3 + 9x^2 + 6x + 3
 * Where each of the x-terms are representative of the term in the polynomial of that degree. The coefficients are
 * always in the front, and the polynomial is always represented in the form shown above. Although, terms that have a
 * leading coefficient of 1 need not include the actual coefficient, as is convention. Also, any term that has a 0
 * coefficient need not be included, as also is convention. Addition is commutative and associative, the terms can
 * also be written in any order, as it is mathematically accurate.
 *
 * @author Luvai Cutlerywala
 * @version 1.0
 */
public class PolynomialParser implements Parser<Polynomial> {

    private final HashMap<Integer, Double> coefficients = new HashMap<>();

    @Override
    public void parse(String input) {
        String[] terms = input.strip().split("\\+"); //Terms are split using the addition symbol.
        for(int i = 0; i < terms.length; ++i){
            terms[i] = terms[i].strip(); //Strip all terms of leading and trailing whitespace.
        }

        ArrayList<String> listOfTerms = new ArrayList<>(List.of(terms));

        for(int i = 0; i < listOfTerms.size(); ++i){
            if(!listOfTerms.get(i).contains("x")){
                coefficients.put(0, Double.parseDouble(listOfTerms.get(i))); //Filter through for the constant term, and remove it once it has been added to the map.
                listOfTerms.remove(i);
                i--;
            } else if(!listOfTerms.get(i).contains("^")){
                coefficients.put(1, Double.parseDouble(listOfTerms.get(i).replaceAll("x", ""))); //The same, but for the linear term.
                listOfTerms.remove(i);
                i--;
            }
        }

        for(String term: listOfTerms){
            String[] parts = term.split("x");
            if(parts[0].isBlank()){
                coefficients.put(Integer.parseInt(parts[1].replaceAll("\\^", "")), 1.0);
            } else {
                coefficients.put(Integer.parseInt(parts[1].replaceAll("\\^", "")), Double.parseDouble(parts[0]));
            }
        }

    }

    @Override
    public HashMap<Integer, Double> getRepresentation() {
        return coefficients;
    }
}
