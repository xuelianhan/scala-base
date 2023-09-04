package org.ict.base.array

import scala.collection.mutable.ListBuffer
import scala.util.Sorting
/**
 * @author sniper
 * @date 04 Sep 2023
 * LC15, Medium, frequency=123
 */
object ThreeSum {

    /**
     * Time Cost 759ms
     * @param nums
     * @return
     */
    def threeSum(nums: Array[Int]): List[List[Int]] = {
        if (nums == null || nums.length < 3) {
            return List.empty[List[Int]]
        }

        Sorting.quickSort(nums)
        val n = nums.length
        val res = ListBuffer[List[Int]]()

        for (i <- 0 until n - 2) {
            // Skip duplicated items
            if (i > 0 && nums(i) == nums(i - 1)) {
              // Continue to the next iteration
            } else {
              var lo = i + 1
              var hi = n - 1

              while (lo < hi) {
                  val sum = nums(i) + nums(lo) + nums(hi)
                  if (sum == 0) {
                      res += List(nums(i), nums(lo), nums(hi))
                      lo += 1
                      hi -= 1

                      // Skip duplicated items
                      while (lo < hi && nums(lo) == nums(lo - 1)) {
                        lo += 1
                      }
                      while (lo < hi && nums(hi) == nums(hi + 1)) {
                        hi -= 1
                      }
                  } else if (sum < 0) {
                      lo += 1
                  } else {
                      hi -= 1
                  }
              }
          }
        }
        res.toList
    }

}
