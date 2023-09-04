package org.ict.base

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC50, Medium, frequency=165
 */
object PowXN {

    /**
     * Time Cost 467ms
     * @param x
     * @param n
     * @return
     */
    def myPow(x: Double, n: Int): Double = {
        var m: Long = n
        var y = x
        if (m < 0) {
            m = -m
            y = 1 / y
        }

        var res = 1.0
        while (m > 0) {
            if ((m & 1) > 0) {
                res *= y
            }
            y *= y
            m >>= 1
        }

        res
    }

}
