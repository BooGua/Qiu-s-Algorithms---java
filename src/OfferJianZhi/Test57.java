package OfferJianZhi;

import org.junit.Test;

public class Test57 {
    @Test
    public void test() {
        int[] ints = {1, 2, 4, 7, 11, 15, 16, 17, 19, 23};
        int target = 15;
        int location = TargetLocation(ints, target);
        FinalLocation(ints, location, target);
    }

    private void FinalLocation(int[] ints, int location, int target) {
        int i = 0, j = location;
        while (i < j) {
            if (ints[i] + ints[j] == target) {
                System.out.println(ints[i] + " " + ints[j]);
                break;
            } else if (ints[i] + ints[j] < target) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
    }

    private int TargetLocation(int[] ints, int target) {
        int i = 0, j = ints.length - 1, mid = (i + j) / 2;
        while (i <= j) {
            if (i == j) {
                return i;
            }
            if (ints[mid] == target || (ints[mid] < target && ints[mid + 1] > target)) {
                return mid;
            } else if (ints[mid] > target) {
                j = mid - 1;
                mid = (i + j) / 2;
            } else {
                i = mid + 1;
                mid = (i + j) / 2;
            }
        }
        return -1;
    }
}
