package OfferZhenTi;

/**
 * 【题目描述】AB两队进行PK，每队有n个英雄，每局一个英雄出战进行PK，（且每个英雄只能出战一次），每个英雄都有武力值，
 * 武力值大的英雄获胜，武力值相同平局，平局没有得失，每赢一局该队获得100个元宝，输一局损失100个元宝。求A队最多可以赢多少元宝。
 * <p>
 * 【输入】
 * 第一行：一个正整数n（0<n<=1000），表示每一队有多少个英雄，
 * 第二行：n个整数表示A队每个英雄的武力值。（武力值>0）
 * 第三行：n个整数表示B队每个英雄的武力值。（武力值>0）
 * <p>
 * 【输出】
 * 输出一个整数，A队可以赢得的最大元宝数，可能为负。
 * <p>
 * 【样例输入】
 * 4
 * 9 7 5 3
 * 10 8 5 2
 * <p>
 * 【样例输出】
 * 200
 */

import java.util.Arrays;
import java.util.LinkedList;

public class WanMeiShiJie_1 {
    public static void main(String[] arg) {
        /*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] teamA = new int[n];
        int[] teamB = new int[n];
        for (int i = 0; i < n; i++) {
            teamA[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            teamB[i] = scanner.nextInt();
        }
        */
        int n = 4;
//        int[] teamA = {9, 7, 5, 3};
//        int[] teamB = {10, 8, 5, 2};

        int[] teamA = {9, 10, 11, 12};
        int[] teamB = {5, 6, 7, 8};

        System.out.println(getMostBonus(n, teamA, teamB));
    }

    public static int getMostBonus(int n, int teamA[], int teamB[]) {
        Arrays.sort(teamA);
        Arrays.sort(teamB);
        int score = 0;
        LinkedList<Integer> teamAList = new LinkedList<>();
        LinkedList<Integer> teamBList = new LinkedList<>();
        for (int e :
                teamA) {
            teamAList.add(e);
        }
        for (int e :
                teamB) {
            teamBList.add(e);
        }
        for (int i = n - 1; i >= 0; i--) { // 用 A 中最大的 maxA 去匹配 B 中比 maxA 小的数中最大的数。
            int temp = teamAList.get(teamAList.size() - 1);
            int index = FindMinMax(temp, teamBList);
            if (index > -1) {
                score += 100;
                teamAList.remove(i);
                teamBList.remove(index);
            } else {
                break;
            }
        }
        score = score + GetRescore(teamAList, teamBList);
        return score;
    }

    private static int GetRescore(LinkedList<Integer> teamAList, LinkedList<Integer> teamBList) {
        if (teamAList.size() == 0) {
            return 0;
        }
        if (teamAList.get(teamAList.size() - 1) == teamBList.get(0))
            return -(teamAList.size() - 1) * 100;
        return -teamAList.size() * 100;
    }

    private static int FindMinMax(int number, LinkedList<Integer> teamBList) {
        for (int i = teamBList.size() - 1; i >= 0; i--) {
            if (teamBList.get(i) < number) {
                return i;
            }
        }
        return -1;
    }
}
