package lesson0301;

import java.util.ArrayList;

public class TestArr<T> {
    private T[] arr;

    public TestArr(T[] arr) {
        this.arr = arr;
    }

    public T[] getArr() {
        return arr;
    }

    public void info() {
        String s = "[";
        for (T arrItem: arr) {
            System.out.print(s + arrItem);
            s = ", ";
        }
        System.out.println("]");
    }

    public boolean changeItems(int i, int j) {
        if (i >= arr.length || j >= arr.length) {
            return false;
        }
        T arrItem = arr[i];
        arr[i] = arr[j];
        arr[j] = arrItem;
        return true;
    }

    public ArrayList<T> getArrayList(){
        ArrayList<T> list = new ArrayList(arr.length);
        for (T arrItem: arr) {
            list.add(arrItem);
        }
        return list;
    }
}
