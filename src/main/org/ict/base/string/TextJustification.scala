package org.ict.base.string
import scala.collection.mutable.ListBuffer


/**
 * @author sniper
 * @date 05 Sep 2023
 * LC68, Hard, frequency=64
 */
object TextJustification {

    /**
     * Time Cost 473ms
     * @param words
     * @param maxWidth
     * @return
     */
    def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
        val res = ListBuffer[String]()
        var i = 0
        val out = new StringBuilder()
        while (i < words.length) {
            var j = i
            var len = 0
            while (j < words.length && (len + words(j).length + j - i) <= maxWidth) {
                len += words(j).length
                j += 1
            }
            var spaces = maxWidth - len

            for (k <- i until j) {
                out.append(words(k))
                if (spaces > 0) {
                    val allocatedSpaces = calculateHowAllocate(words.length, j, k, spaces)
                    appendSpaces(out, allocatedSpaces)
                    spaces -= allocatedSpaces
                }
            }
            res += out.toString()
            out.clear()
            i = j
        }
        res.toList
    }

    private def calculateHowAllocate(lengthOfWords: Int, j: Int, k: Int, spaces: Int): Int = {
        var allocatedSpaces = 0
        if (j == lengthOfWords) {
            if (j == k + 1) {
                allocatedSpaces = spaces
            } else {
                allocatedSpaces = 1
            }
        } else {
            if (j - 1 - k > 0) {
                allocatedSpaces = assignEvenlyOrLeft(spaces, j - 1 - k)
            } else {
                allocatedSpaces = spaces
            }
        }
        allocatedSpaces
    }

    private def assignEvenlyOrLeft(spaces: Int, slots: Int): Int = {
        if (spaces % slots == 0) {
            spaces / slots
        } else {
            spaces / slots + 1
        }
    }

    private def appendSpaces(out: StringBuilder, allocatedSpaces: Int): Unit = {
        for (_ <- 0 until allocatedSpaces) {
            out.append(" ")
        }
    }

}
