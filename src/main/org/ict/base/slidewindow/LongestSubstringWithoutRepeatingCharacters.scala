package org.ict.base.slidewindow

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC3, Medium, frequency=157
 */
object LongestSubstringWithoutRepeatingCharacters {

    /**
     * Time Cost 506ms
     * @param s
     * @return
     */
    def lengthOfLongestSubstring(s: String): Int = {
        var res = 0
        if (s == null || s.isEmpty) {
            return res
        }

        val map = Array.fill(256)(-1)
        var start = -1

        for (i <- 0 until s.length) {
            val ch = s(i)
            if (map(ch) > start) {
              start = map(ch)
            }
            map(ch) = i
            res = math.max(res, i - start)
        }

        res
    }

}
