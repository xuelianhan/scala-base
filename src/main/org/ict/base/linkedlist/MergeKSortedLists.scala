package org.ict.base.linkedlist
import scala.collection.mutable.PriorityQueue

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC23, Hard, frequency=98
 */
object MergeKSortedLists {

    /**
     * Time Cost 662ms
     * @param lists
     * @return
     */
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        if (lists == null || lists.isEmpty) {
            return null
        }
        /**
         *  use -node.x as the ordering criteria, effectively reversing the ordering to be in descending order.
         *  This should merge the lists in ascending order as expected.
         */
        val queue = PriorityQueue.empty[ListNode](Ordering.by((node: ListNode) => -node.x))

        for (head <- lists) {
          if (head != null) {
              queue.enqueue(head)
          }
        }

        val dummy = new ListNode(0)
        var pre = dummy

        while (queue.nonEmpty) {
            val cur = queue.dequeue()
            pre.next = cur
            pre = cur

            if (cur.next != null) {
                queue.enqueue(cur.next)
            }
        }

        dummy.next
    }
}

class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
}
