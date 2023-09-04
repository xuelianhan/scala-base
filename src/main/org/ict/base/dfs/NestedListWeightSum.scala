package org.ict.base.dfs

import scala.collection.mutable.{Queue, ListBuffer}

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC339, Medium, frequency=134
 */
object NestedListWeightSum {

    def depthSumV2(nestedList: List[NestedInteger]): Int = {
        val res = Array(0)
        dfsV2(nestedList, 1, res)
        res(0)
    }

    private def dfsV2(nestedList: List[NestedInteger], depth: Int, res: Array[Int]): Unit = {
        for (item <- nestedList) {
            if (item.isInteger) {
                res(0) += item.getInteger * depth
            } else {
                dfsV2(item.getList, depth + 1, res)
            }
        }
    }

    def depthSumV1(nestedList: List[NestedInteger]): Int = {
        dfs(nestedList, 1)
    }

    private def dfs(nestedList: List[NestedInteger], depth: Int): Int = {
        var sum = 0
        for (item <- nestedList) {
          if (item.isInteger) {
              sum += item.getInteger * depth
          } else {
              sum += dfs(item.getList, depth + 1)
          }
        }
        sum
    }

    def depthSum(nestedList: List[NestedInteger]): Int = {
        val queue = Queue.empty[NestedInteger]
        for (item <- nestedList) {
            queue.enqueue(item)
        }

        var res = 0
        var depth = 0
        while (queue.nonEmpty) {
            depth += 1
            val size = queue.size
            for (_ <- 0 until size) {
                val cur = queue.dequeue()
                if (cur.isInteger) {
                    res += cur.getInteger * depth
                } else {
                    for (item <- cur.getList) {
                      queue.enqueue(item)
                    }
                }
            }
        }
        res
    }

}

class NestedInteger {
      def isInteger: Boolean = false
      def getInteger: Int = 0
      def getList: List[NestedInteger] = null
}
