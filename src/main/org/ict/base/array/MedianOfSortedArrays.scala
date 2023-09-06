package org.ict.base.array

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC4, Hard, frequency=105
 */
object MedianOfSortedArrays {

    /**
     * Time Cost 650ms
     * @param nums1
     * @param nums2
     * @return
     */
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val m = nums1.length
        val n = nums2.length
        val aux = new Array[Int](m + n)
        var i = 0
        var j = 0
        var k = 0

        while (i < m && j < n) {
            if (nums1(i) <= nums2(j)) {
                aux(k) = nums1(i)
                i += 1
            } else {
                aux(k) = nums2(j)
                j += 1
            }
            k += 1
        }

        while (i < m) {
            aux(k) = nums1(i)
            i += 1
            k += 1
        }

        while (j < n) {
            aux(k) = nums2(j)
            j += 1
            k += 1
        }

        val lo = 0
        val hi = m + n - 1
        val mid = lo + (hi - lo) / 2
        var res = 0.0

        if ((m + n) % 2 == 0) {
            res = (aux(mid) + aux(mid + 1)) / 2.0
        } else {
            res = aux(mid)
        }

        res
    }

}
