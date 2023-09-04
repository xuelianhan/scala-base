package org.ict.base.tree

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC1650, Medium, frequency=160
 */
object LowestCommonAncestorOfBTIII {

    def main(args: Array[String]): Unit = {
        // Create a sample tree:
        //      3
        //     / \
        //    5   1
        //   / \ / \
        //  6  2 0  8
        val root = new Node(3)
        val node5 = new Node(5)
        val node1 = new Node(1)
        val node6 = new Node(6)
        val node2 = new Node(2)
        val node0 = new Node(0)
        val node8 = new Node(8)

        root.left = node5
        root.right = node1
        node5.left = node6
        node5.right = node2
        node1.left = node0
        node1.right = node8

        node5.parent = root
        node1.parent = root
        node6.parent = node5
        node2.parent = node5
        node0.parent = node1
        node8.parent = node1


        // Test case 1: Common ancestor of nodes 5 and 1 should be 3
        val result1 = lowestCommonAncestorV1(node5, node1)
        println(s"Common ancestor of 5 and 1: ${result1.value}") // Output should be 3

        // Test case 2: Common ancestor of nodes 5 and 4 should be 5
        val node4 = new Node(4)
        node4.parent = node5
        val result2 = lowestCommonAncestorV1(node5, node4)
        println(s"Common ancestor of 5 and 4: ${result2.value}") // Output should be 5

        // Test case 3: Common ancestor of nodes 6 and 8 should be 3
        val result3 = lowestCommonAncestorV1(node6, node8)
        println(s"Common ancestor of 6 and 8: ${result3.value}") // Output should be 3
    }
    def lowestCommonAncestorV1(p: Node, q: Node): Node = {
        var a = p
        var b = q
        while (a != b) {
            a = if (a == null) q else a.parent
            b = if (b == null) p else b.parent
        }
        a
    }
}
class Node {
    var value: Int = 0
    var left: Node = null
    var right: Node = null
    var parent: Node = null

    def this(value: Int) {
        this()
        this.value = value
    }
}
