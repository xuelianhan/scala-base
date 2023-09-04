package org.ict.base.string

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC680, Easy, frequency=252
 */
object ValidPalindromeII {

    def main(args: Array[String]): Unit = {
        val input = "abca"
        val result = validPalindrome(input)
        println(result)
    }

  /**
   * Time Cost 552ms
   * @param s
   * @return
   */
    def validPalindromeV1(s: String): Boolean = {
        def isValid(arr: Array[Char], lo: Int, hi: Int): Boolean = {
          @scala.annotation.tailrec
          def loop(left: Int, right: Int): Boolean = {
              if (left >= right) true
              else if (arr(left) != arr(right)) false
              else loop(left + 1, right - 1)
          }

          loop(lo, hi)
        }

        @scala.annotation.tailrec
        def loop(lo: Int, hi: Int): Boolean = {
            if (lo >= hi) true
            else if (s(lo) != s(hi)) isValid(s.toCharArray, lo + 1, hi) || isValid(s.toCharArray, lo, hi - 1)
            else loop(lo + 1, hi - 1)
        }

        loop(0, s.length - 1)
    }

  /**
   * Time Cost 573ms
   * @param s
   * @return
   */
  def validPalindrome(s: String): Boolean = {
        def isValid(arr: Array[Char], lo: Int, hi: Int): Boolean = {
            var left = lo
            var right = hi
            while (left < right) {
                if (arr(left) != arr(right)) {
                    return false
                }
                left += 1
                right -= 1
            }
            true
        }

        var lo = 0
        var hi = s.length - 1
        val arr = s.toCharArray

        while (lo < hi) {
            if (arr(lo) != arr(hi)) {
                return isValid(arr, lo + 1, hi) || isValid(arr, lo, hi - 1)
            }
            lo += 1
            hi -= 1
        }
        true
    }

}
