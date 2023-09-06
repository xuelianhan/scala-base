package org.ict.base.trie
import scala.collection.mutable.ListBuffer
import scala.util.Sorting
/**
 * @author sniper
 * @date 05 Sep 2023
 * LC1268, Medium, frequency=68
 */
object SearchSuggestionsSystem {

    /**
     * Time Cost 739ms
     * @param products
     * @param searchWord
     * @return
     */
    def suggestedProducts(products: Array[String], searchWord: String): List[List[String]] = {
        Sorting.quickSort(products)
        val root = new TrieNode
        for ((product, index) <- products.zipWithIndex) {
            root.insert(product, index)
        }
        val res = root.search(searchWord)
        res.map { list =>
            list.map(products)
        }.toList
    }


}

class TrieNode {
    val idxList = ListBuffer.empty[Int]
    val children = Array.fill[TrieNode](26)(null)

    def insert(word: String, i: Int): Unit = {
        var node = this
        for (ch <- word) {
            val idx = ch - 'a'
            if (node.children(idx) == null) {
                node.children(idx) = new TrieNode
            }
            node = node.children(idx)
            if (node.idxList.size < 3) {
                node.idxList += i
            }
        }
    }

    def search(word: String): Array[List[Int]] = {
        val n = word.length
        val res = Array.fill[List[Int]](n)(List.empty)

        var node = this
        for (i <- 0 until n) {
            val idx = word.charAt(i) - 'a'
            if (node.children(idx) == null) {
                return res
            }
            node = node.children(idx)
            res(i) = node.idxList.toList
        }
        res
    }
}
