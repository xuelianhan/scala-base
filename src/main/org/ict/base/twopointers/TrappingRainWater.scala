package org.ict.base.twopointers

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC42, Hard, frequency=134
 */
object TrappingRainWater {

    /**
     * Time Cost 545ms
     * @param height
     * @return
     */
    def trap(height: Array[Int]): Int = {
          var left = 0
          var right = height.length - 1

          var res = 0
          var maxLeft = 0
          var maxRight = 0
          while (left <= right) {
              if (height(left) <= height(right)) {
                // The left bar is lower, so we fill water in the left bar.
                  if (height(left) >= maxLeft) {
                      maxLeft = height(left)
                  } else {
                      res += maxLeft - height(left)
                  }
                  left += 1
              } else {
                  // The right bar is lower, so we fill water in the right bar.
                  if (height(right) >= maxRight) {
                      maxRight = height(right)
                  } else {
                      res += maxRight - height(right)
                  }
                  right -= 1
              }
          }
          res
      }

}
