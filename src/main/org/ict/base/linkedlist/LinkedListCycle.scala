package org.ict.base.linkedlist

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC141, Easy, frequency=7
 */
object LinkedListCycle {

    def hasCycle(head: ListNode): Boolean = {
        var fast: ListNode = head
        var slow: ListNode = head
        while (fast != null && fast.next != null) {
            fast = fast.next.next
            slow = slow.next
            if (fast == slow) {
                return true
            }
        }
        false
    }

    class ListNode(var _x: Int = 0) {
        var next: ListNode = null
        var x: Int = _x
    }

}
