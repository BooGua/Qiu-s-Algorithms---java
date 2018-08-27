package Search;

import org.junit.Test;

import java.util.Arrays;

/**
 * 二分查找（折半查找）。
 */
public class BinarySearch {

    /**
     * 在 ints 中 查询 number 的位置，若无返回 -1。
     */
    private int BinarySearchIndex(int[] ints, int number) {
        int left = 0, right = ints.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(ints[mid] == number){
                return mid;
            }
            else if(ints[mid] < number){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void ceShiErFenChaZhao() { // 测试二分查找。
        int[] ints = {1, 3, 4, 5, 6, 7, 9, 13, 15, 16, 19, 23};
        int index = BinarySearchIndex(ints, 13);
        System.out.println(index);

        // 注：其实 Arrays 中自己就有二分查找。注意使用。
        int index2 = Arrays.binarySearch(ints, 13);
        System.out.println(index2);
    }

}
