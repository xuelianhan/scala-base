package org.ict.base.prefixsum

import scala.collection.mutable
/**
 * @author sniper
 * @date 04 Sep 2023
 * LC560, Medium, frequency=185
 */
object SubarraySumEqualsK {

    /**
     * Time Cost 741ms
     * @param nums
     * @param k
     * @return
     */
    def subarraySum(nums: Array[Int], k: Int): Int = {
        var res = 0
        var prefixSum = 0
        val freq = mutable.HashMap[Int, Int]()
        freq.put(0, 1)
        for (num <- nums) {
            prefixSum += num
            res += freq.getOrElse(prefixSum - k, 0)
            freq.put(prefixSum, freq.getOrElse(prefixSum, 0) + 1)
        }
        res
    }

}
