package org.ict.base.bfs

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue
/**
 * @author sniper
 * @date 05 Sep 2023
 * LC199, Medium, frequency=112
 */
object BinaryTreeRightSideView {
  /**
   * Time Cost 523ms
   * @param root
   * @return
   */
  def rightSideView(root: TreeNode): List[Int] = {
        val result = ListBuffer[Int]()
        if (root == null) {
            return result.toList
        }
        val queue = Queue[TreeNode]()
        queue.enqueue(root)
        while (queue.nonEmpty) {
            val size = queue.size
            for (i <- 0 until size) {
                val node = queue.dequeue()
                if (i == 0) {
                  result += node.value
                }
                if (node.right != null) {
                  queue.enqueue(node.right)
                }
                if (node.left != null) {
                  queue.enqueue(node.left)
                }
            }
        }
        result.toList
    }
}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}
