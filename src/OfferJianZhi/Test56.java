package OfferJianZhi;

import org.junit.Test;

/**
 * 思路：若数组中只有一个只出现了一次的数，那么对这个数组的所有数依次异或，最后得到的结果是这个落单的数。
 * 若数组中有两个只出现了一次的数，那么依次异或的结果一定是这俩落单的数A和B异或的结果，即A^B。
 * 假设我们异或完所有的数之后得到的结果是0010，找到它第一个1出现的位数，这里为第3位，那么这第3位便是A和B不同的地方。
 * 我们以第3位是否为1为分组标准，再对原数组进行分组，那么A和B一定会落在两个不同的数组。这时候再对两个数组分别进行依次异或，
 * 那么两个组得到的结果分别就是A和B本身了。
 */
public class Test56 {
    @Test
    public void test() {
        int[] ints = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] a = new int[1];
        int[] b = new int[1];
        FindNumsAppearOnce(ints, a, b);
        System.out.println(a[0] + " " + b[0]);
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < length; i++) // 对数组中的数依次异或下来
            bitResult ^= array[i]; // bitResult是俩光棍异或的结果
        int index = findFirst1(bitResult); // 找到bitResult中第一个1出现的位数,假设是第n位
        for (int i = 0; i < length; i++) {
            if (isBit1(array[i], index)) { // 以第n位是否为1来进行分组
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult) { // 找到二进制数中第一个为1的位数
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;  // 一位一位的移，看你是不是1
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index) { // 判断第index位是否为1
        return ((target >> index) & 1) == 1;
    }
}
