package org.ict.base.dp

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC53, Medium, frequency=152
 */
object MaximumSubArray {

    /**
     * Time Cost 789ms
     * @param nums
     * @return
     */
    def maxSubArray(nums: Array[Int]): Int = {
        var f = nums(0)
        var res = nums(0)

        for (i <- 1 until nums.length) {
            f = nums(i) + math.max(f, 0)
            res = math.max(res, f)
        }

        res
    }
}
