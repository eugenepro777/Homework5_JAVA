package Homework5;


import java.util.Scanner;

public class Task3 {

    /* Реализовать алгоритм пирамидальной сортировки (HeapSort). */

    public static void main(String[] args) {
        int[] sourceArray = fillRandomArray();
        System.out.println("Исходный массив:");
        printArray(sourceArray);
        heapSort(sourceArray);
        System.out.println("Отсортированный массив:");
        printArray(sourceArray);

    }

    public static int[] fillRandomArray() {
        System.out.print("Задайте размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = ((int) (Math.random() * 30));
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int item :
                array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >=0 ; i--) {
            shiftDown(array, i, array.length);
        }
        for (int i = array.length - 1; i > 0 ; i--) {
            swap(array, 0, i);
            shiftDown(array, 0, i);
        }
    }

    private static int leftNode(int i) {
        return 2 * i + 1;
    }

    private static void shiftDown(int[] array, int i, int n) {
        int node;
        int temp;
        for (temp = array[i]; leftNode(i) < n; i = node) {
            node = leftNode(i);
            if (node != n - 1 && (array[node] < array[node + 1]))
                node++;
            if (temp < array[node])
                array[i] = array[node];
            else break;
        }
        array[i] = temp;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }






}
