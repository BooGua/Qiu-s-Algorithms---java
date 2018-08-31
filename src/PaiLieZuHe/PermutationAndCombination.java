package PaiLieZuHe;

import org.junit.Test;

import java.util.Arrays;

/**
 * 排列与组合。
 * 排列的计算公式：A(m,n) = n! / (n - m)!
 * 组合的计算公式：C(m,n) = n! / m!(n - m)!
 */
public class PermutationAndCombination {

    @Test
    public void test() {
        System.out.println(combinationSec(2, 5));
        int[] a = {1, 2, 3, 4, 5};
        allSort(a, 0, a.length - 1);
        String[] b = {"1", "3", "5", "7"};
//        arrangementSelect(b, 3);
        combinationSelect(b, 3);
    }

    /**
     * 阶乘。
     */
    private static long factorial(int n) {
        long sum = 1;
        while (n > 0) {
            sum = sum * n--;
        }
        return sum;
    }

    /**
     * 排列计算公式A<sup>m</sup><sub>n</sub> = n!/(n - m)!
     *
     * @param m
     * @param n
     * @return
     */
    public static long arrangement(int m, int n) {
        return m <= n ? factorial(n) / factorial(n - m) : 0;
    }

    /**
     * 组合计算公式C<sup>m</sup><sub>n</sub> = n! / (m! * (n - m)!)
     *
     * @param m
     * @param n
     * @return
     */
    public static long combination(int m, int n) {
        return m <= n ? factorial(n) / (factorial(m) * factorial((n - m))) : 0;
    }

    /**
     * 替换阶乘的另一种方式(从n开始递减相乘，乘m个数)
     *
     * @param n
     * @param m
     * @return
     */
    private static long factorialSec(int m, int n) {
        long sum = 1;

        while (m > 0 && n > 0) {
            sum = sum * n--;
            m--;
        }
        return sum;
    }

    /**
     * 排列的优化算法。
     *
     * @param m
     * @param n
     * @return
     */
    public static long arrangementSec(int m, int n) {
        return m <= n ? factorialSec(m, n) : 0;
    }

    /**
     * 组合的优化算法，使用杨辉三角。
     *
     * @param m
     * @param n
     * @return
     */
    public static long combinationSec(int m, int n) {
        int result = 0;
        if (m > n) {
            return result;
        }
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i][1] = i;
        }
        for (int i = 2; i < arr[0].length; i++) {
            for (int j = 2; j <= i; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % 1000000007;
            }
        }
        result = arr[n][m]; // 注意这里是 arr[n][m] 而不是 arr[m][n]。
        return result;
    }

    // 排列组合各种情况的输出：

    /**
     * 全排列输出。
     *
     * @param array
     * @param begin
     * @param end
     */
    void allSort(int[] array, int begin, int end) {
        if (begin == end) {
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = begin; i <= end; i++) {
            swap(array, begin, i);
            allSort(array, begin + 1, end);
            swap(array, begin, i);
        }
    }

    static void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    /**
     * 排列选择（从列表中选择n个排列）
     *
     * @param dataList 待选列表
     * @param n        选择个数
     */
    public static void arrangementSelect(String[] dataList, int n) {
        System.out.println(String.format("A(%d, %d) = %d", dataList.length, n,
                arrangement(n, dataList.length)));
        arrangementSelect(dataList, new String[n], 0);
    }

    /**
     * 排列选择，A（m, n）
     *
     * @param dataList    待选列表
     * @param resultList  前面（resultIndex-1）个的排列结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex) {
        // 将结果集的第1、2、3...n个元素设置为 dataList 的第 resultIndex 个。
        int resultLen = resultList.length;
        if (resultIndex >= resultLen) { // 全部选择完时，输出排列结果
            System.out.println(Arrays.asList(resultList));
            return;
        }

        // 递归选择下一个
        for (int i = 0; i < dataList.length; i++) {
            // 判断待选项是否存在于排列结果中
            boolean exists = false;
            for (int j = 0; j < resultIndex; j++) {
                if (dataList[i].equals(resultList[j])) {
                    exists = true;
                    break;
                }
            }
            if (!exists) { // 排列结果不存在该项，才可选择
                resultList[resultIndex] = dataList[i];
                arrangementSelect(dataList, resultList, resultIndex + 1);
            }
        }
    }

    /**
     * 组合选择（从列表中选择n个组合）,C(m, n)
     *
     * @param dataList 待选列表
     * @param n        选择个数
     */
    public static void combinationSelect(String[] dataList, int n) {
        System.out.println(String.format("C(%d, %d) = %d",
                dataList.length, n, combination(dataList.length, n)));
        combinationSelect(dataList, 0, new String[n], 0);
    }

    /**
     * 组合选择
     *
     * @param dataList    待选列表
     * @param dataIndex   待选开始索引
     * @param resultList  前面（resultIndex-1）个的组合结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex) {
        int resultLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            System.out.println(Arrays.asList(resultList));
            return;
        }

        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) {
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1);
        }
    }

}
