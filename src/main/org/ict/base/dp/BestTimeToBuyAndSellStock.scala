package org.ict.base.dp

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC121, Easy, frequency=148
 */
object BestTimeToBuyAndSellStock {

    /**
     * Time Cost 873ms
     * @param prices
     * @return
     */
    def maxProfit(prices: Array[Int]): Int = {
        var res = 0
        var buy = Int.MaxValue

        for (price <- prices) {
          buy = math.min(buy, price)
          res = math.max(res, price - buy)
        }

        res
    }
}
