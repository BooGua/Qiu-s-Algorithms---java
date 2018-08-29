package Another;

import org.junit.Test;

import java.util.*;

/**
 * 全排列，使用 Set 去掉重复项。
 */
public class AllPermutation {

    void allSort(int[] array, int begin, int end) {
        if (begin == end) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = begin; i <= end; i++) {
            swap(array, begin, i);
            allSort(array, begin + 1, end);
            swap(array, begin, i);
        }
    }

    static void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    @Test
    public void test() {
        int[] ints = {1, 2, 3, 4, 5};
        allSort(ints, 0, ints.length - 1);
    }

}
