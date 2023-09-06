package org.ict.base.stack

import scala.collection.mutable.ArrayDeque

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC921, Medium, frequency=100
 */
object MinimumAddToMakeParenthesesValid {

    /**
     * Time Cost 442ms
     * @param s
     * @return
     */
    def minAddToMakeValidV5(s: String): Int = {
          var l = 0
          var r = 0

          for (c <- s.toCharArray) {
              if (c == '(') {
                  l += 1
              } else if (l > 0) {
                  l -= 1
              } else {
                  r += 1
              }
          }

          l + r
    }

    def minAddToMakeValidV3(s: String): Int = {
        val stack = new ArrayDeque[Char]()

        for (c <- s.toCharArray) {
          if (c == ')' && stack.nonEmpty && stack.last == '(') {
              stack.removeLast()
          } else {
              stack += c
          }
        }

        stack.size
    }
}
