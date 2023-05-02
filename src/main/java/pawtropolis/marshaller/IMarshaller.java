package pawtropolis.marshaller;


public interface IMarshaller<T,V> {
    T marshall(V v);
}
