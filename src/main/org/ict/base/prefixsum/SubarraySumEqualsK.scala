package org.ict.base.prefixsum

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC560, Medium, frequency=185
 */
object SubarraySumEqualsK {
    def subarraySum(nums: Array[Int], k: Int): Int = {
        var res = 0
        var prefixSum = 0
        val freq = scala.collection.mutable.HashMap[Int, Int]()
        freq.put(0, 1)
        for (num <- nums) {
            prefixSum += num
            res += freq.getOrElse(prefixSum - k, 0)
            freq.put(prefixSum, freq.getOrElse(prefixSum, 0) + 1)
        }
        res
    }

}
