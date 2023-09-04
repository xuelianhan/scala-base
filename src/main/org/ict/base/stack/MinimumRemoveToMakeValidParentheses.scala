package org.ict.base.stack

import scala.collection.mutable.Stack

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC1249, Medium, frequency=282.
 */
object MinimumRemoveToMakeValidParentheses {


    def minRemoveToMakeValidV4(s: String): String = {
        //todo
        null
    }

    def minRemoveToMakeValidV3(s: String): String = {
        //todo
        null
    }

    def minRemoveToMakeValidV2(s: String): String = {
        //todo
        null
    }

    /**
     * Time Cost 543ms
     * @param s
     * @return
     */
    def minRemoveToMakeValidV1(s: String): String = {
        if (s == null || s.isEmpty) {
            return ""
        }

        val stack = Stack[Int]()
        val arr = s.toCharArray
        for (i <- 0 until arr.length) {
            if (arr(i) == '(') {
                stack.push(i)
            } else if (arr(i) == ')') {
                if (stack.isEmpty) {
                    arr(i) = '*'
                } else {
                    stack.pop()
                }
            }
        }

        while (!stack.isEmpty) {
            arr(stack.pop) = '*'
        }

        val res = new StringBuilder()
        for (i <- 0 until arr.length) {
            if (arr(i) != '*') {
                res.append(arr(i))
            }
        }

        res.toString()
    }

    /**
     * Time Cost 657ms
     * @param s
     * @return
     */
    def minRemoveToMakeValid(s: String): String = {
        if (s == null || s.isEmpty) {
            return ""
        }
        val stack = Stack[Int]()
        for (i <- 0 until s.length) {
            val ch = s.charAt(i)
            if (ch == '(') {
                stack.push(i)
            } else if (ch == ')') {
                if (!stack.isEmpty && s.charAt(stack.top) == '(') {
                    stack.pop()
                } else {
                    stack.push(i)
                }
            }
        }

        val set = stack.toSet
        val res = new StringBuilder()
        for (i <- 0 until s.length) {
            if (!set.contains(i)) {
                res.append(s.charAt(i))
            }
        }

        res.toString()
    }

}
