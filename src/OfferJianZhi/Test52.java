package OfferJianZhi;

import org.junit.Test;

/**
 * 在排序数组中查找数字。
 * <p>
 * 关键：排好序的数组，用三次二分查找。
 */
public class Test52 {
    @Test
    public void test() {
        int[] numbers = {1, 2, 3, 3, 3, 3, 4, 5};
        int target = 3;
        int n = FindFruquenceNumber(numbers, target);
        System.out.println(n);
    }

    private int FindFruquenceNumber(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int mid = (i + j) / 2;
        int location = -1;
        while (i < j) {
            if (numbers[mid] < target) {
                i = mid + 1;
                mid = (i + j) / 2;
            } else if (numbers[mid] == target) {
                location = mid;
                break;
            } else {
                j = mid - 1;
                mid = (i + j) / 2;
            }
        }
        int left = FindLeft(numbers, location, target);
        int right = FindRight(numbers, location, target);
        return right - left + 1;
    }

    private int FindRight(int[] numbers, int location, int target) {
        int i = location, j = numbers.length - 1;
        int mid = (i + j) / 2;
        while (i < j) {
            if (numbers[mid + 1] > target && numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] == target && numbers[mid + 1] == target) {
                i = mid + 1;
                mid = (i + j) / 2;
            } else {
                j = mid - 1;
                mid = (i + j) / 2;
            }
        }
        return numbers.length - 1;
    }

    private int FindLeft(int[] numbers, int location, int target) {
        int i = 0, j = location;
        int mid = (i + j) / 2;
        while (i < j) {
            if (numbers[mid] == target && numbers[mid - 1] == target) {
                j = mid - 1;
                mid = (i + j) / 2;
            } else if (numbers[mid] == target && numbers[mid - 1] < target) {
                return mid;
            } else {
                i = mid + 1;
                mid = (i + j) / 2;
            }
        }
        return 0;
    }
}
