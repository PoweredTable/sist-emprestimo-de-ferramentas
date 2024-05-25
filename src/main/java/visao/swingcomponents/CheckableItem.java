package visao.swingcomponents;

public class CheckableItem<T> {
    private final String text;
    private final T item;
    private boolean selected;

    public CheckableItem(String text, T item) {
        this.text = text;
        this.item = item;
        this.selected = false;
    }

    public CheckableItem(String text, T item, boolean selected) {
        this.text = text;
        this.item = item;
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return text;
    }
}
