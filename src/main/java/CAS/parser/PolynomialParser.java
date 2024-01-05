package CAS.parser;

import CAS.algebraicObjects.Polynomial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Extracts the
 */
public class PolynomialParser implements Parser<Polynomial> {

    private final HashMap<Integer, Double> coefficients = new HashMap<>();

    public PolynomialParser(){}

    public PolynomialParser(String input){
        parse(input);
    }

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
