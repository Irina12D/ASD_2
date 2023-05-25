package org.example;

import java.util.Arrays;

public class Main {

    private static int LEFT(int i) {
        return (2*i + 1);
    }

    private static int RIGHT(int i) {
        return (2*i + 2);
    }

    private static void swap(int[] Arr, int i, int j)
    {
        int temp = Arr[i];
        Arr[i] = Arr[j];
        Arr[j] = temp;
    }

    private static void heapify(int[] Arr, int i, int size)
    {

        int left = LEFT(i);
        int right = RIGHT(i);

        int largest = i;

        if (left < size && Arr[left] > Arr[i]) {
            largest = left;
        }

        if (right < size && Arr[right] > Arr[largest]) {
            largest = right;
        }

        if (largest != i)
        {
            swap(Arr, i, largest);
            heapify(Arr, largest, size);
        }
    }

    public static int pop(int[] Arr, int size)
    {
        // если в куче нет элементов
        if (size <= 0) {
            return -1;
        }

        int top = Arr[0];

        Arr[0] = Arr[size-1];

        heapify(Arr, 0, size - 1);

        return top;
    }
    public static void heapsort(int[] Arr)
    {
        int n = Arr.length;

        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(Arr, i--, n);
        }

        while (n > 0)
        {
            Arr[n - 1] = pop(Arr, n);
            n--;
        }
    }
    public static void main(String[] args) {

        int[] myArray = new int[10];
        for (int i = 0; i < myArray.length; i++) 
            myArray[i] = ((int)(Math.random() * (99-10)) + 10);
        System.out.println(Arrays.toString(myArray));

        heapsort(myArray);

        System.out.println(Arrays.toString(myArray));
    }
}