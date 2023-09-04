package org.ict.base.bst

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC938, Easy, frequency=149
 */
object RangeSumOfBST {

    /**
     * Time Cost 659ms
     * @param root
     * @param low
     * @param high
     * @return
     */
    def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
        if (root == null) {
            return 0
        }

        if (root.value < low) {
            return rangeSumBST(root.right, low, high)
        }

        if (root.value > high) {
            return rangeSumBST(root.left, low, high)
        }

        root.value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
    }


}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
}
