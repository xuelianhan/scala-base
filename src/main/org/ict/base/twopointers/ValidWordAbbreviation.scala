package org.ict.base.twopointers

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC408, Easy, frequency=114
 */
object ValidWordAbbreviation {
    def validWordAbbreviationV3(word: String, abbr: String): Boolean = {
        val m = word.length
        val n = abbr.length
        var p = 0
        var cnt = 0

        for (j <- 0 until n) {
            if (abbr.charAt(j).isDigit) {
                if (cnt == 0 && abbr.charAt(j) == '0') {
                    return false
                }
              cnt = cnt * 10 + abbr.charAt(j).asDigit
            } else {
                p += cnt
                if (p >= m || word.charAt(p) != abbr.charAt(j)) {
                    return false
                }
                p += 1
                cnt = 0
            }
        }

        p + cnt == m
    }
}
