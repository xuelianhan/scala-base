package org.ict.base.binarysearch

import scala.util.Random

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC528, Medium, frequency=182
 */
class RandomPickWithWeight(_w: Array[Int]) {

    private val prefixSum: Array[Int] = {
        val n = _w.length
        val prefixSum = new Array[Int](n)
        prefixSum(0) = _w(0)
        for (i <- 1 until n) {
            prefixSum(i) = prefixSum(i - 1) + _w(i)
        }
        prefixSum
    }

    private val random = new Random()

    /**
     * Time Cost 878ms
     * @return
     */
    def pickIndex(): Int = {
        val n = prefixSum.length
        var lo = 0
        var hi = n - 1
        val target = random.nextInt(prefixSum(n - 1))
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (prefixSum(mid) > target) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }
        lo
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * var obj = new Solution(w)
 * var param_1 = obj.pickIndex()
 */
