package org.ict.base.heap

import scala.collection.mutable.PriorityQueue

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC215, Medium, frequency=154
 */
object KthLargestElementInAnArray {

    /**
     * Time Cost 953ms
     * @param nums
     * @param k
     * @return
     */
    def findKthLargest(nums: Array[Int], k: Int): Int = {
        val maxHeap = PriorityQueue.empty[Int].reverse

        for (num <- nums) {
            maxHeap.enqueue(num)
            if (maxHeap.size > k) {
                maxHeap.dequeue()
            }
        }

        maxHeap.head
    }

}
