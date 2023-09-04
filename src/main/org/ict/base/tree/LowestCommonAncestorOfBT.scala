package org.ict.base.tree

import scala.collection.mutable

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC236, Medium, frequency=186
 */
object LowestCommonAncestorOfBT {


    /**
     * Time Cost 614ms
     * @param root
     * @param p
     * @param q
     * @return
     */
    def lowestCommonAncestorV1(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        val parent = mutable.HashMap[TreeNode, TreeNode]()
        val queue = mutable.Queue[TreeNode]()
        parent.put(root, null)
        queue.enqueue(root)

        while (!parent.contains(p) || !parent.contains(q)) {
            val size = queue.size
            for (i <- 0 until size) {
                val cur = queue.dequeue()
                if (cur.left != null) {
                  parent.put(cur.left, cur)
                  queue.enqueue(cur.left)
                }

                if (cur.right != null) {
                  parent.put(cur.right, cur)
                  queue.enqueue(cur.right)
                }
            }
        }

        val ancestors = mutable.Set[TreeNode]()
        var temp = p // Use a temporary variable to iterate
        while (temp != null) {
            ancestors.add(temp)
            temp = parent(temp)
        }

        var qTemp = q // Use a temporary variable to iterate for q
        while (!ancestors.contains(qTemp)) {
            qTemp = parent(qTemp)
        }
        qTemp
    }

    /**
     * Time Cost 579ms
     * The main difference between the Java code and the Scala code is the way that the null value is handled.
     * In Java, the null value is represented by the keyword null.
     * In Scala, the null value is represented by the null object.
     *
     * In the Java code, the condition null == root checks if the value of root is the null value.
     * In the Scala code, the condition root == null checks if the value of root is the null object.
     *
     * The rest of the code is the same in both languages.
     * The code recursively finds the lowest common ancestor of the two nodes p and q.
     * If both nodes are in the left subtree of the current node,
     * then the lowest common ancestor is the left child of the current node.
     * If both nodes are in the right subtree of the current node,
     * then the lowest common ancestor is the right child of the current node.
     * Otherwise, the lowest common ancestor is the current node.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
        if (root == null || root == p || root == q) {
            return root
        }

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        left match {
            case null => right
            case _ => right match {
                case null => left
                case _ => root
            }
        }
    }
}

class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
}


