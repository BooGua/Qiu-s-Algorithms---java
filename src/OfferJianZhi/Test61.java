package OfferJianZhi;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 扑克牌中的顺子，不算 Q K A 的情况。
 */
public class Test61 {
    @Test
    public void test() {
        for (int j = 0; j < 100; j++) {
            HashMap<Integer, Integer> pokers = new HashMap<>();
            for (int i = 1; i <= 13; i++) {
                pokers.put(i, 4);
            }
            pokers.put(14, 2); // 14 代表王。
            int[] ints = new int[5];
            SuiJiChouPai(ints, pokers);
            System.out.println(Arrays.toString(ints));
//            boolean isShunZi = IsShunZi(ints);
            boolean isShunZi2 = IsShunZi2(ints);
            System.out.println(isShunZi2);
            System.out.println("-------------------------");
        }
        /*
        HashMap<Integer, Integer> pokers = new HashMap<>();
        for (int i = 1; i <= 13; i++) {
            pokers.put(i, 4);
        }
        pokers.put(14, 2); // 14 代表王。
        int[] ints = {1, 2, 3, 4, 5};
        boolean isShunZi2 = IsShunZi2(ints);
        System.out.println(isShunZi2);
        System.out.println("-------------------------");
        */
    }

    private boolean IsShunZi2(int[] ints) {
        int blankSpace = 0;
        int number14 = 0;
        for (int i = 0; i < 5; i++) {
            if (ints[i] == 14) {
                number14++;
            }
        }
        for (int i = 1; i < 5 - number14; i++) {
            int temp = ints[i] - ints[i - 1] - 1;
            if (temp < 0) {
                return false;
            } else {
                blankSpace = blankSpace + temp;
            }
        }
        if (blankSpace <= number14) {
            return true;
        }
        return false;
    }

    /*
    判断是否为顺子。
    1. 分为有没王、一个王、两个王三种情况。
     */
    private boolean IsShunZi(int[] ints) {
        int number14 = 0;
        for (int i = 0; i < 5; i++) {
            if (ints[i] == 14) {
                number14++;
            }
        }
        if (number14 == 0) { // 没有王的情况。
            System.out.println("No King!");
            for (int i = 1; i <= 4; i++) {
                if (ints[i] - ints[i - 1] != 1) {
                    return false;
                }
            }
            return true;
        } else if (number14 == 1) { // 一个王的情况。
            int number1 = 0;
            int number2 = 0;
            System.out.println("One King!");
            for (int i = 1; i <= 3; i++) {
                if (ints[i] - ints[i - 1] == 1) {
                    number1++;
                } else if (ints[i] - ints[i - 1] == 2) {
                    number2++;
                } else {
                    return false;
                }
            }
            if ((number1 == 2 && number2 == 1) || number1 == 3) {
                return true;
            } else {
                return false;
            }
        } else {
            int number1 = 0;
            int number2 = 0;
            int number3 = 0;
            System.out.println("Two King!");
            for (int i = 1; i <= 2; i++) {
                if (ints[i] - ints[i - 1] == 1) {
                    number1++;
                } else if (ints[i] - ints[i - 1] == 2) {
                    number2++;
                } else if (ints[i] - ints[i - 1] == 3) {
                    number3++;
                } else {
                    return false;
                }
            }
            if (number1 == 2 || (number1 == 1 && number3 == 1) || number2 == 2) {
                return true;
            } else {
                return false;
            }
        }
    }

    /*
    随机抽排。
     */
    private void SuiJiChouPai(int[] ints, HashMap<Integer, Integer> pokers) {
        int count = 0;
        while (count < 5) {
            int n = (int) (Math.random() * 14 + 1);
            if (pokers.containsKey(n)) {
                ints[count] = n;
                int tempNumbers = pokers.get(n);
                tempNumbers--;
                if (tempNumbers != 0) {
                    pokers.put(n, tempNumbers);
                }
                count++;
            }
        }
        Arrays.sort(ints);
    }
}
