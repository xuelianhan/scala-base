package org.ict.base.hash

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * @author sniper
 * @date 30 Nov, 2022
 * LC1207
 */
object UniqueNumberOfOccurrences {
    def uniqueOccurrences(arr: Array[Int]): Boolean = {
        val map = arr.groupBy(el => el).map(e => (e._1, e._2.length))
        val set = map.values.toSet
        map.size == set.size
    }

    def main(args: Array[String]): Unit = {
        var arr1 = Array(1, 2, 2, 1, 1, 3)
        uniqueOccurrences(arr1)
    }

}
