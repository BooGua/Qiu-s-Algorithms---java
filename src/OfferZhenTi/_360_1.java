package OfferZhenTi;

import java.util.Scanner;

/**
 * 题目：小明买了一些彩色的气球用绳子串在一条线上，想要装饰房间，每个气球都染上了一种颜色，每个气球的形状都
 * 是各不相同的。我们用1到9一共9个数字表示不同的颜色，如12345则表示一串5个颜色各不相同的气球串。但小明希望
 * 得到不出现重复颜色的气球串，那么现在小明需要将这个气球串剪成多个较短的气球串，小明一共有多少种剪法？如原
 * 气球串12345的一种是剪法是剪成12和345两个气球串。
 * <p>
 * 注意每种剪法需满足最后的子串中气球颜色各不相同（如果满足该条件，允许不剪，即保留原串）。两种剪法不同当且
 * 仅当存在一个位置，在一种剪法里剪开了，而在另一种中没剪开。详见样例分析。
 * <p>
 * 分析：动态规划，考虑前i个有多少种剪法，枚举最后剪的一段转移。
 */
public class _360_1 {
    // 各不相同还能理解，例如：
    // 气球：1 2 3 4 5  6
    // 剪法：1 2 4 8 16 32
    // 但是有相同颜色气球出现的时候就无法理解了。丧~
    // 例如：1 2 3 4 5 6 3
    // 结果 = 32+16+8+4 = 60（从后往前加）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
//        int n = 5;
//        int[] a = {1, 2, 3, 4, 5};
            // dp[i]表示前i个气球组合的最大剪枝方法数,其实这是跟跳台阶类似的。
            // 也就是说，把前面不相同的颜色的气球的剪枝数加起来就OK了！
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                int[] cnt = new int[10]; // 用来存储从0—9的数字每个数字出现了几回。
                for (int j = i - 1; j >= 0; j--) {
                    cnt[a[j]]++;
                    if (cnt[a[j]] > 1) // 有相同的就退出。
                        break;
                    dp[i] = (dp[i] + dp[j]) % 1000000007;
                }
            }
            System.out.println(dp[n]);
        }
        scanner.close();
    }
}
