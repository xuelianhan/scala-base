package org.ict.base.array

import scala.collection.mutable.ListBuffer

/**
 * @author sniper
 * @date 31 Aug 2023 
 */
object MergeIntervals {

    def main(args: Array[String]): Unit = {
        val intervals = Array(Array(1, 4), Array(0, 4))
        val mergedIntervals = mergeIntervals(intervals)
        mergedIntervals.foreach(row => println(row.mkString(",")))
        //println(mergedIntervals)
    }

  /**
   * Notice here we should use the sorted array instead of the original one to proceed.
   * This is the difference between Scala and Java.
   * e.g. intervals: [[1,4],[0,4]], output [1, 4], but expected [0, 4]
   * Time Cost 622ms
   * @param intervals
   * @return
   */
    def mergeIntervalsV2(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        val sortedIntervals = intervals.sortBy(_(0))
        val ans = scala.collection.mutable.ArrayBuffer.empty[Array[Int]]
        var prevInterval = sortedIntervals(0)
        for (interval <- sortedIntervals.drop(1)) {
            if (prevInterval(1) >= interval(0)) {
                prevInterval(1) = math.max(prevInterval(1), interval(1))
            } else {
                ans.append(prevInterval)
                prevInterval = interval
            }
        }
        ans.append(prevInterval)
        ans.toArray
    }


    /**
     * Notice here we should use the sorted array instead of the original one to proceed.
     * This is the difference between Scala and Java.
     * e.g. intervals: [[1,4],[0,4]], output [1, 4], but expected [0, 4]
     * Time Cost 637ms
     *
     * @param intervals
     * @return
     */
    def mergeIntervalsV1(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        val sortedIntervals = intervals.sortBy(_(0))
        var start = sortedIntervals(0)(0)
        var end = sortedIntervals(0)(1)
        var ans = scala.collection.mutable.ArrayBuffer.empty[Array[Int]]
        for (i <- 1 until sortedIntervals.length) {
            val curStart = sortedIntervals(i)(0)
            val curEnd = sortedIntervals(i)(1)
            if (end < curStart) {
                ans.append(Array(start, end))
                start = curStart
                end = curEnd
            } else {
                end = math.max(end, curEnd)
            }
        }
        ans.append(Array(start, end))
        ans.toArray
    }

    /**
     * Notice here we should use the sorted array instead of the original one to proceed.
     * This is the difference between Scala and Java.
     * e.g. intervals: [[1,4],[0,4]], output [1, 4], but expected [0, 4]
     * Time Cost 659ms
     *
     * @param intervals
     * @return
     */
    def mergeIntervals(intervals: Array[Array[Int]]): Array[Array[Int]] = {
          if (intervals == null || intervals.length == 0) {
              return null
          }
          var sortedIntervals = intervals.sortBy(_(0))
          val mergedIntervals = ListBuffer[Array[Int]]()
          var newInterval = sortedIntervals(0)
          mergedIntervals.append(newInterval)

          for (interval <- sortedIntervals.tail) {
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
