package Another;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 全排列，使用 Set 去掉重复项。
 */
public class AllPermutation {

    private Set<String> set = new HashSet<>(); // 此处使用 Set，为了去掉重复项。
    private LinkedList<String> linkedList = new LinkedList<>();

    public void allPermutationSort(String[] strs) {
        allPermutation(strs, set, 0);
        for (String str : set) {
            linkedList.add(str);
        }
        Collections.sort(linkedList); //todo 打印和排序
        for (String str : linkedList) {
            System.out.print(str + " ");
        }
    }

    private static void allPermutation(String[] strings, Set<String> set, int start) {
        if (start == strings.length - 1) {
            set.add(strsToString(strings));
        } else {
            for (int i = start; i <= strings.length - 1; i++) {
                if (strings[i] != strings[start]) {
                    swap(strings, i, start);
                    allPermutation(strings, set, start + 1);
                    swap(strings, start, i);
                } else {
                    allPermutation(strings, set, start + 1);
                }
            }
        }
    }

    private static String strsToString(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb = sb.append(strings[i]);
        }
        return sb.toString();
    }

    private static void swap(String[] strings, int i, int start) {
        String temp = strings[i];
        strings[i] = strings[start];
        strings[start] = temp;
    }

    @Test
    public void test() {
        String[] strs = {"a", "a", "b", "c"};
        AllPermutation allPermutation = new AllPermutation();
        allPermutation.allPermutationSort(strs);
    }

}
