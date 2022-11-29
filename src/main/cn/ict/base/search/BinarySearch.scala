package cn.ict.base.search

/**
 * @author sniper
 * @date 29 Nov, 2022 
 */
class BinarySearch {

    def search(nums: Array[Int], target: Int): Int = {
        var lo = 0
        var hi = nums.length - 1
        while (lo <= hi) {
           var mid = lo + (hi - lo) / 2
           if (nums(mid) > target) {
              hi = mid - 1
           } else if (nums(mid) < target) {
              lo = mid + 1
           } else {
              return mid
           }
        }
        -1
    }

}
