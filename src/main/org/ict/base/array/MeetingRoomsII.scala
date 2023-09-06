package org.ict.base.array
import scala.collection.mutable.TreeMap

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC253, Medium, frequency=106
 */
object MeetingRoomsII {

    def minMeetingRoomsV2(intervals: Array[Array[Int]]): Int = {
        val map = TreeMap[Int, Int]()

        for (a <- intervals) {
            val start = a(0)
            val end = a(1)
            map(start) = map.getOrElse(start, 0) + 1
            map(end) = map.getOrElse(end, 0) - 1
        }

        var res = 0
        var rooms = 0
        for ((_, value) <- map) {
            rooms += value
            res = Math.max(res, rooms)
        }

        res
    }

    def minMeetingRoomsV1(intervals: Array[Array[Int]]): Int = {
        // Range for start and end times is [0, 10^6]
        val n = 1000010
        val prefixSum = new Array[Int](n)

        for (a <- intervals) {
            prefixSum(a(0)) += 1
            prefixSum(a(1)) -= 1
        }

        var res = prefixSum(0)

        for (i <- 1 until n) {
            prefixSum(i) += prefixSum(i - 1)
            res = Math.max(res, prefixSum(i))
        }

        res
    }

}
