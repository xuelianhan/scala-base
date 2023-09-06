package org.ict.base.string
import scala.collection.mutable.ArrayBuffer


/**
 * @author sniper
 * @date 05 Sep 2023
 * LC423, Medium, frequency=69
 */
object ReconstructOriginalDigitsFromEnglish {

    /**
     * Time Cost 540ms
     * @param s
     * @return
     */
    def originalDigits(s: String): String = {
        val counter = Array.ofDim[Int](26)
        for (c <- s) {
            counter(c - 'a') += 1
        }

        val cnt = Array.ofDim[Int](10)
        cnt(0) = counter('z' - 'a')
        cnt(2) = counter('w' - 'a')
        cnt(4) = counter('u' - 'a')
        cnt(6) = counter('x' - 'a')
        cnt(8) = counter('g' - 'a')

        cnt(3) = counter('h' - 'a') - cnt(8)
        cnt(5) = counter('f' - 'a') - cnt(4)
        cnt(7) = counter('s' - 'a') - cnt(6)

        cnt(1) = counter('o' - 'a') - cnt(0) - cnt(2) - cnt(4)
        cnt(9) = counter('i' - 'a') - cnt(5) - cnt(6) - cnt(8)

        val res = new ArrayBuffer[Char]()
        for (i <- 0 until 10) {
            for (_ <- 0 until cnt(i)) {
                res += ('0' + i).toChar
            }
        }
        res.mkString
    }

}
