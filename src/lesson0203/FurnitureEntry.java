package lesson0203;

import java.util.Objects;

public class FurnitureEntry {
    private String type;
    private int count;

    public FurnitureEntry(String type) {
        this.type = type;
        count = 0;
    }

    public FurnitureEntry(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void incCount() {
        count ++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FurnitureEntry that = (FurnitureEntry) o;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return String.format("%s, %d шт.", type, count);
    }
}
