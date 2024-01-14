package CAS.algebraicObjects;

public interface Operations<T> {

    T add(T addend);

    T subtract(T subtrahend);

    T scalarMultiplication(double scalar);

}
