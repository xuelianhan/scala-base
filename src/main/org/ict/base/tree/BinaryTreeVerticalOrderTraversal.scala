package org.ict.base.tree

import scala.collection.mutable.Queue
import scala.collection.mutable.TreeMap

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC314, Medium, frequency=188
 */
object BinaryTreeVerticalOrderTraversal {

    /**
     * todo
     * need testing
     * @param root
     * @return
     */
    def verticalOrderV2(root: TreeNode): List[List[Int]] = {
          val res = List[List[Int]]()
          if (root == null) {
              return res
          }

          val queue = Queue[(Int, TreeNode)]()
          queue.enqueue((0, root))

          val treeMap = TreeMap[Int, List[Int]]()
          while (!queue.isEmpty) {
              val (seq, node) = queue.dequeue()
              treeMap.getOrElseUpdate(seq, List[Int]()).appended(node._v)

              if (node.left != null) {
                  queue.enqueue((seq - 1, node.left))
              }

              if (node.right != null) {
                  queue.enqueue((seq + 1, node.right))
              }
          }

          res.appendedAll(treeMap.values)
          res
      }

      class TreeNode {
          var _v: Integer = null
          var left: TreeNode = null
          var right: TreeNode = null

          def this(_v: Integer) {
              this()
              this._v = _v
          }

          def this(_v: Integer, left: TreeNode, right: TreeNode) {
              this()
              this._v = _v
              this.left = left
              this.right = right
          }
      }

}
