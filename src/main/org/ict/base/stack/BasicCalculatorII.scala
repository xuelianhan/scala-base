package org.ict.base.stack

import scala.collection.mutable.ArrayDeque

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC227, Medium, frequency=127
 */
object BasicCalculatorII {

    /**
     * Time Cost 507ms
     * @param s
     * @return
     */
    def calculate(s: String): Int = {
        if (s == null || s.isEmpty) {
            return 0
        }

        val n = s.length
        var num = 0
        var prevSign = '+'
        val arr = s.toCharArray
        val stack = ArrayDeque[Int]()

        for (i <- 0 until n) {
            val ch = arr(i)
            if (ch.isDigit) {
                num = 10 * num + (ch - '0')
            }

            if (i == n - 1 || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (prevSign == '+') {
                    stack += num
                } else if (prevSign == '-') {
                    stack += (-num)
                } else if (prevSign == '*') {
                    stack += (stack.removeLast() * num)
                } else if (prevSign == '/') {
                    stack += (stack.removeLast() / num)
                }
                prevSign = ch
                num = 0
            }
        }

        var res = 0
        while (stack.nonEmpty) {
            res += stack.removeLast()
        }
        res
    }

}
