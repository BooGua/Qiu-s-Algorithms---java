package OfferJianZhi;

import org.junit.Test;

import java.util.TreeSet;

/**
 * 丑数。
 */
public class Test49 {
    @Test
    public void test() {
        int n = 14;
        long result = UglyNumber(n);
        System.out.println(result);
    }

    private long UglyNumber(int n) {
        TreeSet<Long> treeSet = new TreeSet<>();
        long[] uglies = new long[n];
        uglies[0] = 1;
        for (int i = 1; i < n; i++) {
            treeSet.add(uglies[i - 1] * 2);
            treeSet.add(uglies[i - 1] * 3);
            treeSet.add(uglies[i - 1] * 5);
            uglies[i] = treeSet.pollFirst();
        }
        return uglies[n - 1];
    }
}
