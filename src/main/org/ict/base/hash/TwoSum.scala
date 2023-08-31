package org.ict.base.hash

/**
 *
 * @author sniper
 * @date 31 Aug 2023
 * LC1, Easy, frequency=396
 */
object TwoSum {

    /**
     * The function takes two arguments: an array of integers nums and an integer target.
     * It creates a mutable hash map map to store the mapping from a number to its index in the array.
     * For each number nums(i) in the array, it checks if the hash map contains the complement target - nums(i).
     * If it does, the function returns an array with the indices of the two numbers.
     *
     * Otherwise, the function adds the number nums(i) to the hash map.
     * If the loop finishes without finding the two numbers, the function returns an empty array.
     *
     * @param nums
     * @param target
     * @return
     */
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val map = scala.collection.mutable.HashMap[Int, Int]()
        for (i <- nums.indices) {
            val complement = target - nums(i)
            if (map.contains(complement)) {
                return Array(map(complement), i)
            }
            map.put(nums(i), i)
        }
        Array.empty[Int]
    }

    /**
     * @see <a href="https://www.baeldung.com/scala/printing-arrays"></a>
     * The difference between val and var is that val makes a variable immutable — like final in Java,
     * and var makes a variable mutable.
     * Because val fields can't vary,
     * some people refer to them as values rather than variables.
     * @param args
     */
    def main(args: Array[String]): Unit = {
        val nums = Array(4, 2, 1)
        var target = 3
        var res = twoSum(nums, target);
        println(res.mkString(","))
    }
}
