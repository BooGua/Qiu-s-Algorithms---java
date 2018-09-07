package OfferJianZhi;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * 队列的最大值。
 */
public class Test59 {
    @Test
    public void test() {
        int[] ints = {2, 3, 4, 2, 6, 2, 5, 1};
        int window = 3;
        PrintWindowMax(ints, window);
//        assertEquals(1, 1);
    }

    private void PrintWindowMax(int[] ints, int window) {
        LinkedList<Integer> queMax = new LinkedList<>();
        LinkedList<Integer> queAnother = new LinkedList<>();
        queMax.add(ints[0]);

        for (int i = 0; i < ints.length; i++) {
            if (queMax.size() == 0 && queAnother.size() == 0) {
                queMax.add(ints[i]);
                continue;
            }
            if (queMax.size() == 0 && queAnother.size() != 0) {
                TiaoZheng(queMax, queAnother);
            }
            if (ints[i] >= queMax.getLast()) {
                while (queAnother.size() != 0) {
                    queMax.add(queAnother.removeFirst());
                }
                queMax.add(ints[i]);
            } else {
                queAnother.add(ints[i]);
            }
            System.out.println(queMax.getFirst());
        }
    }

    private void TiaoZheng(LinkedList<Integer> queMax, LinkedList<Integer> queAnother) {
        queMax.add(queAnother.removeFirst());
        int max = queAnother.getFirst();
        int location = 0;
        for (int i = 0; i < queAnother.size(); i++) {
            if (queAnother.get(i) > max) {
                max = queAnother.get(i);
                location = i;
            }
        }
        for (int i = 0; i <= location; i++) {
            queAnother.add(queMax.removeFirst());
        }
    }
}
