package OfferJianZhi;

import org.junit.Test;

public class Test58 {
    @Test
    public void test() {
        String s = "I am a student.";
        ReverseString(s);
    }

    private void ReverseString(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        ReverseStringLittle(chars, i, j);
        for (char e :
                chars) {
            System.out.print(e);
        }
        i = 0;
        j = 0;
        while (j <= chars.length - 1) {
            while (chars[j] != ' ' && j != chars.length - 1) {
                j++;
            }
            if (j != chars.length - 1) {
                ReverseStringLittle(chars, i, j - 1);
                i = j + 1;
                j = j + 1;
            } else {
                ReverseStringLittle(chars, i, j);
                j++;
            }
        }
        System.out.println();
        for (char e :
                chars) {
            System.out.print(e);
        }
    }

    private void ReverseStringLittle(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
