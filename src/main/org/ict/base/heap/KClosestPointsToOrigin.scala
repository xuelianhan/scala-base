package org.ict.base.heap

import scala.collection.mutable.PriorityQueue

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC973, Medium, frequency=183
 */
object KClosestPointsToOrigin {

    val points = Array(Array(1, 3), Array(-2, 2))
    val k = 1
    val result = kClosest(points, k)
    result.foreach(arr => println(arr.mkString("[", ", ", "]")))

    /**
     * Time Cost 1018ms
     *
     * @param points
     * @param k
     * @return
     */
    def kClosestV1(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
        val minHeap = PriorityQueue[(Int, Int)]()(
            (p1, p2) => (p1._1 * p1._1 + p1._2 * p1._2) - (p2._1 * p2._1 + p2._2 * p2._2)
        )

        for (p <- points) {
            minHeap.enqueue((p(0), p(1)))
            if (minHeap.size > k) {
              minHeap.dequeue()
            }
        }

        val res = Array.ofDim[Int](k, 2)
        var i = 0
        while (i < k) {
            val (x, y) = minHeap.dequeue() // Extract the elements of the tuple
            res(i)(0) = x
            res(i)(1) = y
            i += 1
        }

        res
    }


  /**
     * Time Cost 1126ms
     * @param points
     * @param k
     * @return
     */
    def kClosest(points: Array[Array[Int]], k: Int): Array[Array[Int]] = {
        val minHeap = PriorityQueue.empty[(Int, Int)](Ordering.by { case (x, y) => x * x + y * y })

        for (p <- points) {
            minHeap.enqueue((p(0), p(1)))
            if (minHeap.size > k) {
                minHeap.dequeue()
            }
        }

        val res = Array.ofDim[Int](k, 2)
        var i = 0
        while (i < k) {
            val (x, y) = minHeap.dequeue()
            res(i)(0) = x
            res(i)(1) = y
            i += 1
        }

        res
    }


}
