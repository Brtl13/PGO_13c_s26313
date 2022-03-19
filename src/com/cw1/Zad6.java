package com.cw1;

import java.util.Random;

public class Zad6 {
    public static int[] sortArr(int[] arr) {
        boolean loop = false;
        int tmp = 0;
        do {
            loop = false;
            for (int i = 1; i < 10; ++i) {
                if (arr[i - 1] > arr[i]) {
                    tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    loop = true;
                }
            }
        } while (loop);
        return arr;
    }
    public static String printArray(int[] arr) {
        String retString = "[";
        int len = arr.length - 1;
        for(int i = 0; i <= len; ++i) {
            retString= retString + arr[i];
            if(i < len) {
                    retString = retString + ", ";
            }
        }
        return retString + "]";
    }

    public static void main(String[] args) {
        int arr[] = new int[10];
        Random generator = new Random();

        for (int i = 0; i < 10; i++) {
            arr[i] = generator.nextInt(900) + 100;
        }
        System.out.println("Generated Array: " + printArray(arr));
        System.out.println("Sorted Array: " + printArray(sortArr(arr)));
    }
}
