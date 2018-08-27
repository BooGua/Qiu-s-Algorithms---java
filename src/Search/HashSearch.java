package Search;

import org.junit.Test;

import java.util.Arrays;

/**
 * 哈希查找
 */
public class HashSearch {

    private int[] hash;
    private int hashLength = 13;

    public HashSearch(int[] ints) {
        hashLength = 13; // 这个值是哈希表的长度。
        hash = new int[hashLength];
        Arrays.fill(hash, -1);
        for (int i = 0; i < ints.length; i++) {
            HashInsert(hash, hashLength, ints[i]);
        }
    }

    public int HashSearchIndex(int number) {
        int index = number % hashLength;
        for (int i = 0; i < hash.length; i++) {
            if(hash[index] == number){
                return index;
            }else{
                index = (index + 1) % hashLength;
            }
        }
        return -1;
    }

    private void HashInsert(int[] hash, int hashLength, int anInt) {
        int index = anInt % hashLength;
        for (int i = 0; i < hashLength; i++) {
            if (hash[index] == -1) {
                hash[index] = anInt;
                return;
            } else {
                index = (index + 1) % hashLength;
            }
        }
    }

    @Test
    public void ceShiHaXiChaZhao() { // 测试哈希查找。
//        int[] ints = {6, 7, 9, 13, 15, 16, 19, 23};
//        HashSearch hashSearch = new HashSearch(ints);
//        int index = hashSearch.HashSearchIndex(23);
//        System.out.println();
//        System.out.println("INDEX:" + index);
    }
}
