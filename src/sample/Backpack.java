package sample;

import java.util.List;

public class Backpack {
    List<Item> items;
    int maxValue;


    public Backpack(List<Item> items, int maxValue) {
        this.items = items;
        this.maxValue = maxValue;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "items=" + items +
                ", maxValue=" + maxValue +
                '}';
    }
}
