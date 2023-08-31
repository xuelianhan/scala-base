package org.ict.base.array

import scala.collection.mutable.ListBuffer

/**
 * @author sniper
 * @date 31 Aug 2023 
 */
object MergeIntervals {

  def main(args: Array[String]): Unit = {

  }

  /**
   * e.g. intervals: [[1,4],[0,4]], output [1, 4], but expected [0, 4]
   *
   * @param intervals
   * @return
   */
  def mergeIntervals(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        if (intervals == null || intervals.length == 0) {
            return null
        }
        intervals.sortBy(_(0))
        val mergedIntervals = ListBuffer[Array[Int]]()
        var newInterval = intervals(0)
        mergedIntervals.append(newInterval)

        for (interval <- intervals.tail) {
            if (newInterval(1) < interval(0)) {
                /**
                 * The last interval in the list has no intersection with the current interval.
                 * Add the current interval to the list.
                 */
                newInterval = interval
                mergedIntervals.append(newInterval)
            } else {
                /**
                 * Merge the last interval in the list with the current interval.
                 */
                newInterval(1) = math.max(newInterval(1), interval(1))
            }
        }

        /**
         * Convert list to array.
         */
        mergedIntervals.toArray
    }
}
