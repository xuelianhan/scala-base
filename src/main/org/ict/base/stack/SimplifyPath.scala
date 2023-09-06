package org.ict.base.stack

import scala.collection.mutable.Stack

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC71, Medium, frequency=112
 */
object SimplifyPath {

    /**
     * Time Cost 488ms
     * @param path
     * @return
     */
    def simplifyPath(path: String): String = {
        val stack = Stack[String]()
        val arr = path.split("/")

        for (s <- arr) {
            if (".." == s && stack.nonEmpty) {
                stack.removeLast()
            } else if (s != "" && s != "." && s != "..") {
                stack += s
            }
        }

        "/" + stack.mkString("/")
    }
}
