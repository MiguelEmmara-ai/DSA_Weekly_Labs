package Exercise2_1;

/**
 * Created by Miguel Emmara
 */
public interface ArraySetADT<E> {
    void add(E item);
    void remove(E item);
    E contains(E item);
}
