package OfferZhenTi;

import org.junit.Test;

/**
 * 纸牌博弈问题
 *
 * 题目：有一个整型数组A，代表数值不同的纸牌排成一条线。玩家a和玩家b依次拿走每张纸牌，规定玩家a先拿，玩家b后拿，
 * 但是每个玩家每次只能拿走最左或最右的纸牌，玩家a和玩家b都绝顶聪明，他们总会采用最优策略。请返回最后获胜者的分数。
 * 给定纸牌序列A及序列的大小n，请返回最后分数较高者得分数(相同则返回任意一个分数)。
 *
 * 测试样例：
 * [1,2,100,4],4
 * 返回：101
 *
 * 解析：
 *
 * a和b都是绝顶聪明，他们每次拿元素时，肯定是按对自己最有力的方式拿。该题目先由最普通的递归解法，然后进行优化，到动态规划。
 * 递归方式，对数组arr，元素数为n。
 * F(arr, l , r)表示对于数组arr，元素从l到r，先拿可以达到的最大分数；
 * S(arr, l, r)表示对于数组arr, 元素从l到r，后拿可以达到的最大分数。
 * 对于F(arr, l, r)，先拿时，有两种拿法，拿第一个arr[l]，或最后一个arr[r]；如果拿arr[l]，
 * 那么剩余的arr[l+1,....r]能拿到的最大分数为S(arr, l+1, r)，分数为arr[l] +S(arr, l+1, r)；
 * 如果拿arr[r]，剩余的arr[l, ...r-1]能拿到的最大分数为S(arr, l, r-1)，分数为arr[r] + S(arr, l, r-1)，
 * 因为对于先拿后剩余的数组，当前人再拿的话是后拿的，然后取这两种拿法较大的分数。
 * 对于S(arr, l, r)，如果前一个人先拿了arr[l]，则后拿的分数为F(arr, l+1, r)，如果前一个人先拿了arr[r]，
 * 则后拿的分数为F(arr, l, r-1)，因为对于剩余的元素来说，你是先拿的，取两种方式的较小值才是S的值。
 * （为什么取较小值，而不是较大值？因为a和b都是绝顶聪明人，你是在另一个绝顶聪明人之后才拿的，他给你剩下的肯定是较坏的情况）
 */
public class _360_2 {

    /* 返回较大值 */
    int Max(int a, int b) {
        return ((a > b) ? a : b);
    }

    /* 返回较小值 */
    int Min(int a, int b) {
        return ((a < b) ? a : b);
    }

    /* 对数组arr，从l到r元素，先拿的最大分数 */
    int F(int arr[], int l, int r) {
        if (l == r) {
            return arr[l];
        }
        return Max(arr[l] + S(arr, l + 1, r), arr[r] + S(arr, l, r - 1));
    }

    /* 对数组arr，从l到r元素，后拿的最大分数 */
    int S(int arr[], int l, int r) {
        if (l == r) {
            return 0;
        }
        return Min(F(arr, l + 1, r), F(arr, l, r - 1));
    }

    /**
     * 递归算法。
     */
    int FindWinnerScore(int arr[], int l, int r) {
        int A_score = 0;
        int B_score = 0;
        A_score = F(arr, l, r);
        B_score = S(arr, l, r);
        return ((A_score > B_score) ? A_score : B_score);
    }

    @Test
    public void test() {
        int[] arr = {2, 100, 4};
        System.out.println(FindWinnerScore(arr, 0, 2));
    }
}
