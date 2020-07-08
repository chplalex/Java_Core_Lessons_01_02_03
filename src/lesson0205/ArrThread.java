package lesson0205;

import java.util.Arrays;

public class ArrThread extends Thread {
    private float[] arr;
    private int diff;

    public ArrThread(int size, int diff) {
        this.diff = diff;
        arr = new float[size];
        Arrays.fill(arr, 1);
    }

    public float[] getArr() {
        return arr;
    }

    public void addArr(float[] arr2) {
        float[] arr1 = arr;
        arr = new float[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + diff) / 5) * Math.cos(0.2f + (i + diff) / 5) * Math.cos(0.4f + (i + diff) / 2));
        }
    }
}
