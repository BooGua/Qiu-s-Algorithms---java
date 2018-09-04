package OfferJianZhi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数。
 */
public class Test45 {
    @Test
    public void test() {
        int[] ints = {3, 32, 321};
        ArrayList<String> arrayList = new ArrayList<>();
        for (int e :
                ints) {
            arrayList.add(String.valueOf(e));
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String resultA = o1 + o2;
                String resultB = o2 + o1;
                if (Integer.valueOf(resultA) > Integer.valueOf(resultB)) {
                    return 1;
                }else if(Integer.valueOf(resultA) < Integer.valueOf(resultB)){
                    return -1;
                }
                return 0;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            stringBuilder.append(arrayList.get(i));
        }
        System.out.println(stringBuilder.toString());
    }
}
