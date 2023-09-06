package org.ict.base.hash

import scala.collection.mutable.{Map, ListBuffer}

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC811, Medium, frequency=76
 */
object SubdomainVisitCount {

    /**
     * Time Cost 546ms
     * @param cpdomains
     * @return
     */
    def subdomainVisits(cpdomains: Array[String]): List[String] = {
        val freq = Map[String, Int]()

        for (cpDomain <- cpdomains) {
            val space = cpDomain.indexOf(" ")
            val num = cpDomain.substring(0, space).toInt
            val domain = cpDomain.substring(space + 1)

            for (i <- 0 until domain.length) {
                if (domain(i) == '.') {
                    val subDomain = domain.substring(i + 1)
                    freq(subDomain) = freq.getOrElse(subDomain, 0) + num
                }
            }
            freq(domain) = freq.getOrElse(domain, 0) + num
        }

        val res = ListBuffer[String]()
        for ((key, value) <- freq) {
            res += s"$value $key"
        }
        res.toList
    }
}
