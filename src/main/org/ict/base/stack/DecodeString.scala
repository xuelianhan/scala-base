package org.ict.base.stack

import scala.collection.mutable.ArrayDeque


/**
 * @author sniper
 * @date 05 Sep 2023
 * LC394, Medium, frequency=82
 */
object DecodeString {
    def decodeString(s: String): String = {
        if (s == null || s.isEmpty) {
          return ""
        }

        var num = 0
        var res = ""
        val stack1 = new ArrayDeque[Int]()
        val stack2 = new ArrayDeque[String]()

        for (c <- s.toCharArray) {
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0'
            } else if (c == '[') {
                stack1 += (num)
                stack2 += (res)
                num = 0
                res = ""
            } else if (c == ']') {
                val builder = new StringBuilder()
                for (_ <- 0 until stack1.removeLast()) {
                    builder.append(res)
                }
                res = stack2.removeLast() + builder.toString()
            } else {
                res += c
            }
        }

        res
    }
}
