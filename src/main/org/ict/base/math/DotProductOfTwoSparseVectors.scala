package org.ict.base.math

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC1570, Medium, frequency=121
 */
object DotProductOfTwoSparseVectors {

}

class SparseVectorV1(nums: Array[Int]) {
    private val map: Map[Int, Int] = {
        val mutableMap = collection.mutable.Map[Int, Int]()
        for (i <- nums.indices) {
            if (nums(i) != 0) {
              mutableMap(i) = nums(i)
            }
        }
        mutableMap.toMap
    }

    /**
     * Return the dotProduct of two sparse vectors
     * e.g. nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
     * map:(1, 1),(4, 2)
     * vec:(0, 1),(4, 3),(6, 4)
     *
     * @param vec
     * @return
     */
    def dotProduct(vec: SparseVectorV1): Int = {
        if (map.size < vec.map.size) {
            // Follow-up question answer
            // switch this.map with vec.map if this.map is shorter than vec.map
            vec.dotProduct(this)
        } else {
            /**
             * The following for-loop uses vec.map instead of this.map
             * so the above ensures the vec.map passed in is the shorter one.
             */
            var res = 0
            for (index <- vec.map.keys) {
                if (map.contains(index)) {
                  res += vec.map(index) * map(index)
                }
            }
            res
        }
    }
}
