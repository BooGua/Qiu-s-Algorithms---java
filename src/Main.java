import Another.AllPermutation;
import Search.HashSearch;

public class Main {

    public static void main(String[] args) {
//        int[] ints = {6, 7, 9, 13, 15, 16, 19, 23};
//        HashSearch hashSearch = new HashSearch(ints);
//        int index = hashSearch.HashSearchIndex(6);
//        System.out.println("INDEX:" + index);
        String[] strs = {"a", "a", "z", "z"};
        AllPermutation allPermutation = new AllPermutation();
        allPermutation.allPermutationSort(strs);
    }
}
