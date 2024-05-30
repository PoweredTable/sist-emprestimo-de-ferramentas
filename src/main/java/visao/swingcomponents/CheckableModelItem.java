package visao.swingcomponents;

public class CheckableModelItem<T> extends ModelItem<T> {
    private boolean selected;

    public CheckableModelItem(String text, T item) {
        super(text, item);
        this.selected = false;
    }

    public CheckableModelItem(String text, T item, boolean selected) {
        super(text, item);
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
