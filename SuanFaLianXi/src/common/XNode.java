package common;

public class XNode<T> {

    public T value;

    public XNode<T> left;
    public XNode<T> right;


    public XNode(T value) {
        this.value = value;
    }
}
