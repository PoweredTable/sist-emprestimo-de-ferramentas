package visao.swingcomponents;

public class ModelItem<T> {
    protected final String text;
    protected final T item;

    public ModelItem(String text, T item) {
        this.text = text;
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return text;
    }
}
