package Sorts;

import org.junit.Test;

/**
 * 使用一维数组存储的小顶堆。
 */
public class MinHeap {

    /**
     * 对使用一维数组存储的二叉树建立初始大顶堆。
     */
    private static void heap(int[] data) {
        int start = (data.length - 1) / 2;
        for (int i = start; i >= 1; i--) {
            MaxHeapSwap(data, i, data.length - 1);
        }
    }

    /**
     * 对初始大顶堆进行调整排序。
     */
    private static void maxHeapSort(int[] data) {
        int swapIndex = data.length - 1;
        for (int i = swapIndex; i >= 2; i--) {
            swap(data, 1, i);
            MaxHeapSwap(data, 1, i - 1);
        }
    }

    private static void MaxHeapSwap(int[] data, int index, int end) {
        if (index * 2 <= end && data[index] < data[index * 2]) {
            swap(data, index, index * 2);
            MaxHeapSwap(data, index * 2, end);
        }
        if (index * 2 + 1 <= end && data[index] < data[index * 2 + 1]) {
            swap(data, index, index * 2 + 1);
            MaxHeapSwap(data, index * 2 + 1, end);
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Test
    public void ShiYongCeShi() { // 使用测试。
        int i, size, data[] = {0, 5, 6, 10, 8, 3, 2, 19, 9, 11}; // 注意下标为 0 的元素无用。
        size = data.length;

        MinHeap.heap(data);
        MinHeap.maxHeapSort(data);

        for (i = 1; i < size; i++)
            System.out.print("[" + data[i] + "] ");

        System.out.println();
    }


}
