package CAS;

import CAS.parser.VectorParser;

public class Main {

    public static void main(String[] args){
        VectorParser parser = new VectorParser("  (0.2024678293475624375,   2, 4, 127389838723847)    ");
        double[] vector = parser.getRepresentation();
        for(double component: vector){
            System.out.println(component);
        }
    }

}
