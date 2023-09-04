package org.ict.base.design

import scala.collection.mutable

/**
 * Also, Scala's mutable Map is used to replace Java's HashMap for simplicity.
 * @author sniper
 * @date 31 Aug 2023
 * LC146, Medium, frequency=286
 */
object LRUCache {

    def main(args: Array[String]): Unit = {
        val cache = new LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        println(cache.get(1)) // Output: 1
        cache.put(3, 3)
        println(cache.get(2)) // Output: -1
        cache.put(4, 4)
        println(cache.get(1)) // Output: -1
        println(cache.get(3)) // Output: 3
        println(cache.get(4)) // Output: 4
    }

    /**
     * Time Cost 1625ms
     * @param _capacity
     */
    private class LRUCache(_capacity: Int) {
        private val cache: mutable.Map[Int, Node] = mutable.Map()
        private val head: Node = new Node(0, 0)
        private val tail: Node = new Node(0, 0)
        private var size: Int = 0

        head.next = tail
        tail.prev = head
        def get(key: Int): Int = {
            if (!cache.contains(key)) {
                return -1
            }
            val node: Node = cache(key)
            moveToHead(node)
            node.value
        }

        def put(key: Int, value: Int): Unit = {
            if (cache.contains(key)) {
                val node: Node = cache(key)
                node.value = value
                moveToHead(node)
            } else {
                val node: Node = new Node(key, value)
                cache(key) = node
                addToHead(node)
                size += 1
                if (size > _capacity) {
                    val removedNode: Node = removeTail()
                    cache -= removedNode.key
                    size -= 1
                }
            }
        }

        private def removeNode(node: Node): Unit = {
            node.next.prev = node.prev
            node.prev.next = node.next
        }

        private def removeTail(): Node = {
            val node: Node = tail.prev
            removeNode(node)
            node
        }

        private def addToHead(node: Node): Unit = {
            node.next = head.next
            node.prev = head
            head.next = node
            node.next.prev = node
        }

        private def moveToHead(node: Node): Unit = {
            removeNode(node)
            addToHead(node)
        }
    }
}

/**
 * In Scala, the underscore _ is often used as a placeholder for default values.
 * In the context of class member initialization,
 * using _ as a placeholder initializes the variable with its default value based on its data type.
 * For example, in the line var prev: Node = _, the _ is used to initialize the prev variable of type Node with its default value,
 * which is null for reference types like classes.
 * So, var prev: Node = _ is equivalent to var prev: Node = null,
 * initializing the prev variable to null.
 * @param key
 * @param value
 */
class Node(var key: Int, var value: Int) {
    var prev: Node = _
    var next: Node = _
}
