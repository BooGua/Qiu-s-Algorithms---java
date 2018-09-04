package OfferJianZhi;

import org.junit.Test;

public class Test46 {
    private char[] numbersTranslater = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    private int count = 0;

    @Test
    public void test() {
        int s = 0;
        int result = CountNumber(s);
        System.out.println(result);
    }

    private int CountNumber(int number) {
        String numberS = "" + number;
        CountNumberString(numberS, 0);
        return count;
    }

    // 使用递归得到最后的总和。
    private void CountNumberString(String numberS, int index) {
        if (index == numberS.length() - 1) {
            count++;
            return;
        }
        if (index >= numberS.length()) {
            return;
        }
        CountNumberString(numberS, index + 1);
        if (numberS.charAt(index) == '0') {
            return;
        }
        String s = "" + numberS.charAt(index) + numberS.charAt(index + 1);
        int result = Integer.parseInt(s);
        char resultC = GetLetters(result);
        if (resultC == 'ñ') {
            return;
        } else {
            if (index == numberS.length() - 2) {
                count++;
                return;
            }
            CountNumberString(numberS, index + 2);
        }
    }

    // 返回翻译表中数字对应的字母。
    private char GetLetters(int number) {
        if (number < 0 || number > 25) {
            return 'ñ';
        } else {
            return numbersTranslater[number];
        }
    }
}
