package test_1;

public interface List<E> {

    int size();

    void add( E e) ;

    void remove(int index);

    E get(int index);

    void set(int index, E e);

    int indexOf(E e);

    boolean isEmpty();

    void clear();
}
