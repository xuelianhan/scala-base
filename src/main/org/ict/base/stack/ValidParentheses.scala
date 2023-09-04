package org.ict.base.stack

import scala.collection.mutable.ArrayDeque

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC20, Easy, frequency=177
 */
object ValidParentheses {

  /**
   * Time Cost 456ms
   * Scala's ArrayDeque does not have push and pop methods.
   * Instead, you can use the += and -= methods for adding and removing elements.
   * @param s
   * @return
   */
    def isValid(s: String): Boolean = {
        val stack = ArrayDeque.empty[Char]

        for (ch <- s) {
            ch match {
              case '(' => stack += ')'
              case '[' => stack += ']'
              case '{' => stack += '}'
              case _ =>
                  if (stack.isEmpty || stack.removeLast() != ch) {
                      return false
                  }
            }
        }

        stack.isEmpty
    }
}
