package ej3;

public interface Crud<T> {
    void add(T objeto);
    void delete(T objeto);
    void get(T objeto);
    void getAll(T objeto);
}
