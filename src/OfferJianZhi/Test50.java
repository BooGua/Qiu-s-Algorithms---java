package OfferJianZhi;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 第一个只出现一次的字符。
 */
public class Test50 {
    @Test
    public void test() {
        String s = "abaccdeff";
        char c = TheFirstChar(s);
        System.out.println(c);
    }

    private char TheFirstChar(String s) {
        int[] letters = new int[26];
        Arrays.fill(letters, -1);
        LinkedList<Character> linkedList = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == -1) { // 从未出现过。
                letters[s.charAt(i) - 'a'] = i;
                linkedList.add(s.charAt(i));
            } else {
                letters[s.charAt(i) - 'a'] = i;
                linkedList.removeFirstOccurrence(s.charAt(i));
            }
        }
        return linkedList.getFirst();
    }
}
