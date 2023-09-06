package org.ict.base.binarysearch

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC33, Medium, frequency=85
 */
object SearchInRotatedSortedArray {

    /**
     * Time Cost 483ms
     * @param nums
     * @param target
     * @return
     */
    def search(nums: Array[Int], target: Int): Int = {
        var lo = 0
        var hi = nums.length - 1

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if ((nums(mid) < nums(0)) == (target < nums(0))) {
                // nums(mid) and target are on the same side.
                if (nums(mid) < target) {
                  lo = mid + 1
                } else {
                  hi = mid
                }
            } else if (target < nums(0)) {
                // target on the right side
                lo = mid + 1
            } else {
                // target on the left side
                hi = mid
            }
        }

        if (nums(lo) == target) lo else -1
    }
}
