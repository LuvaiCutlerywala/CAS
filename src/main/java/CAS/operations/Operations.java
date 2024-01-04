package CAS.operations;

public interface Operations<T> {

    T add(T augend, T addend);
    T subtract(T minuend, T subtrahend);

}
