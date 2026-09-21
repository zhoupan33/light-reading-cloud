package com.example.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序算法实现
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 * 稳定排序算法
 */
public class BubbleSort {

    /**
     * 冒泡排序 - 升序
     * @param arr 待排序数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            // 标记本轮是否发生交换，用于优化
            boolean swapped = false;

            // 内层循环进行相邻元素比较和交换
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // 如果本轮没有发生交换，说明数组已经有序，提前结束
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 冒泡排序 - 降序
     * @param arr 待排序数组
     */
    public static void bubbleSortDesc(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {  // 改为小于号实现降序
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 测试升序排序
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组: " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("升序排序: " + Arrays.toString(arr1));

        // 测试降序排序
        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\n原始数组: " + Arrays.toString(arr2));
        bubbleSortDesc(arr2);
        System.out.println("降序排序: " + Arrays.toString(arr2));

        // 测试边界情况
        int[] arr3 = {};
        bubbleSort(arr3);
        System.out.println("\n空数组排序: " + Arrays.toString(arr3));

        int[] arr4 = {1};
        bubbleSort(arr4);
        System.out.println("单元素数组排序: " + Arrays.toString(arr4));

        int[] arr5 = {5, 5, 5, 5};
        bubbleSort(arr5);
        System.out.println("相同元素数组排序: " + Arrays.toString(arr5));
    }
}
