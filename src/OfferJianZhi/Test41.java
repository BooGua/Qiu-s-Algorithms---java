package OfferJianZhi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 【题目描述】如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Test41 {
    private int count = 0;

    // 左半元素
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    // 右半元素
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    public void Insert(Integer num) {
        count++;
        // 如果是偶数，插入到最小堆（右）.
        // 必须先插入最大堆，然后把最大堆的根元素插入最小堆
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        } else {
            //如果是奇数，先放入最小堆，再把最小堆的根元素放入最大堆
            minHeap.offer(num);
            int temp = minHeap.poll();
            maxHeap.offer(temp);
        }
    }

    /*
     * 如果数据总数目是偶数 . 返回最小堆根元素与最大堆根元素的均值 否则返回最大堆的根元素
     */

    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double(maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return new Double(maxHeap.peek());
        }
    }
}
