package OfferJianZhi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * 最小的K个数。
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class Test40 {
    @Test
    public void test() {
        int[] ints = {4, 5, 1, 6, 2, 7, 3, 8, 0, 8, 7, 6, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2};
        int m = 4;
        int[] results = new int[m];
        FindMMin(ints, m, results);
        System.out.println(Arrays.toString(results));
    }

    /**
     * 使用快排。
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input == null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>(k);
        if (k > input.length)
            return list;
        int low = 0;
        int high = input.length - 1;
        int index = partition(input, low, high);
        while (index != k - 1) {
            if (index > k - 1) {
                high = index - 1;
            } else {
                low = index + 1;
            }
            index = partition(input, low, high);
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    //划分操作
    public int partition(int[] array, int start, int end) {
        int pivot = array[start];
        while (start < end) {
            while (start < end && array[end] >= pivot) end--;
            array[start] = array[end];
            while (start < end && array[start] <= pivot) start++;
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }

    ////////////////////////////////////////////////////////////////////
    ///////////////// 我的方法，思路对，但还要继续优化//////////////////
    ////////////////////////////////////////////////////////////////////

    private void FindMMin(int[] ints, int m, int[] results) {
        for (int i = 0; i < m; i++) {
            results[i] = ints[i];
        }
        for (int i = m; i < ints.length; i++) {
            InMin(results, ints[i]);
        }
    }

    private void InMin(int[] results, int anInt) {
        int max = results[0];
        int index = 0;
        for (int i = 1; i < results.length; i++) {
            if (max < results[i]) {
                max = results[i];
                index = i;
            }
        }
        results[index] = anInt < results[index] ? anInt : results[index];
    }

    ////////////////////////////////////////////////////////
    /////////////////////// 优化方法 ///////////////////////
    ////////////////////////////////////////////////////////

    public static ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
        if (input == null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>(k);
        if (k > input.length)
            return list;
        TreeSet<Integer> tree = new TreeSet<Integer>(); // TreeSet 有序！
        for (int i = 0; i < input.length; i++) {
            tree.add(input[i]);
        }
        int i = 0;
        for (Integer elem : tree) {
            if (i >= k)
                break;
            list.add(elem);
            i++;
        }
        return list;
    }
}
