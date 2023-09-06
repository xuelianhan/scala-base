package org.ict.base.linkedlist

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC2, Medium, frequency=119
 */
object AddTwoNumbers {
    /**
     * Time Cost 595ms
     * @param l1
     * @param l2
     * @return
     */
    def addTwoNumbersV4(l1: ListNode, l2: ListNode): ListNode = {
        var carry = 0
        val dummy = new ListNode(0)
        var cur = dummy

        // Because numbers are in reverse order,
        // we add them one by one from lower to higher digit.
        // This is the order of iteration of the list.
        // So we don't need to use a stack here.
        var p1 = l1
        var p2 = l2

        while (p1 != null || p2 != null || carry != 0) {
            var sum = 0
            if (p1 != null) {
                sum += p1.x
                p1 = p1.next
            }
            if (p2 != null) {
                sum += p2.x
                p2 = p2.next
            }
            sum += carry

            val mod = sum % 10
            cur.next = new ListNode(mod)
            cur = cur.next

            carry = sum / 10
        }

        dummy.next
    }
}

class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
}
