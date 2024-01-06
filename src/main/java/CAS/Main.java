package CAS;

import CAS.algebraicObjects.Vector;

public class Main {

    public static void main(String[] args){
        Vector vector = Vector.generateObject("(1.414213562373, 2.71828182846, 3.141592654, 4)");
        for(int i = 1; i < 5; ++i){
            System.out.println(vector.getComponent(i));
        }
    }

}
