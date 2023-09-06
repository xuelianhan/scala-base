package org.ict.base.heap
import scala.collection.mutable.HashMap
import scala.collection.mutable.PriorityQueue
/**
 * @author sniper
 * @date 05 Sep 2023
 * LC347, Medium, frequency=107
 */
object TopKFrequentElements {

    def main(args: Array[String]): Unit = {
        // Example usage
        val nums = Array(1, 1, 1, 2, 2, 3)
        val k = 2
        val result = topKFrequent(nums, k)
        println(result.mkString("[", ", ", "]"))
    }

    /**
     * Time Cost 649ms
     * @param nums
     * @param k
     * @return
     */
    def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
        val res = new Array[Int](k)
        val frequency = HashMap[Int, Int]().withDefaultValue(0)

        for (num <- nums) {
            frequency(num) += 1
        }

        val pq = PriorityQueue[(Int, Int)]()(Ordering.by[(Int, Int), Int](-_._2))

        for ((num, cnt) <- frequency) {
            pq.enqueue(num -> cnt)

            if (pq.size > k) {
              pq.dequeue()
            }
        }

        var i = 0
        while (pq.nonEmpty) {
            res(i) = pq.dequeue()._1
            i += 1
        }

        res
    }

}
