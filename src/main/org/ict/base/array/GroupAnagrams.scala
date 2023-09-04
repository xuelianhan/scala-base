package org.ict.base.array

import scala.collection.mutable.{HashMap, ArrayBuffer, ListBuffer}

/**
 * @author sniper
 * @date 04 Sep 2023
 * LC49, Medium, frequency=138
 */
object GroupAnagrams {

    /**
     * Time Cost 626ms
     * @param strs
     * @return
     */
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        val map = HashMap[String, ListBuffer[String]]()

        for (s <- strs) {
            val arr = s.toCharArray.sorted
            val key = arr.mkString
            map.getOrElseUpdate(key, ListBuffer()).append(s)
        }

        map.values.map(_.toList).toList
    }

}
