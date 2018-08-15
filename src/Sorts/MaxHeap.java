package Sorts;

import org.junit.Test;

/**
 * 使用一维数组存储的大顶堆。
 */
public class MaxHeap {

    /**
     * 对使用一维数组存储的二叉树建立大顶堆。
     *
     * @param data
     * @param size
     */
    private static void heap(int[] data, int size) {
        for (int i = size / 2; i >= 0; i--) {
            if () // 如果有左孩子，对比交换。
            {
            }
        }
    }

    @Test
    public void ShiYongCeShi() { // 使用测试。
        int i, size, data[] = {0, 5, 6, 10, 8, 3, 2, 19, 9, 11};
        size = data.length;
        System.out.print("原始数组：");

        for (i = 1; i < size; i++)
            System.out.print("[" + data[i] + "] ");

        System.out.println("");

        MaxHeap.heap(data, size);
    }
}
