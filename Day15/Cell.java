public class Cell {
    private int i;
    private int j;
    private int value;

    public Cell(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }

    public int getRow() {
        return i;
    }

    public int getColumn() {
        return j;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        value = newValue;
    }
}
