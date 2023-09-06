package org.ict.base.backtracking
import scala.collection.mutable.ListBuffer

/**
 * @author sniper
 * @date 05 Sep 2023
 * LC212, Hard, frequency=67
 */
object WordSearchII {

    /**
     * Time Cost 1673ms
     * @param board
     * @param words
     * @return
     */
    def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
        val res = ListBuffer[String]()
        val root = buildTrie(words)
        for (i <- 0 until board.length) {
            for (j <- 0 until board(0).length) {
                search(board, i, j, root, res)
            }
        }
        res.toList
    }

    def search(board: Array[Array[Char]], i: Int, j: Int, p: TrieNode, res: ListBuffer[String]): Unit = {
        val c = board(i)(j)
        if (c == '#' || p.children(c - 'a') == null) {
            return
        }
        val child = p.children(c - 'a')
        if (child.word.nonEmpty) {
            res += child.word
            child.word = ""
        }

        board(i)(j) = '#'
        val directions = List((0, 1), (1, 0), (0, -1), (-1, 0))
        for ((dx, dy) <- directions) {
            val x = i + dx
            val y = j + dy
            if (x >= 0 && x < board.length && y >= 0 && y < board(0).length) {
                search(board, x, y, child, res)
            }
        }
        board(i)(j) = c
    }

    def buildTrie(words: Array[String]): TrieNode = {
        val root = new TrieNode()
        for (w <- words) {
            var p = root
            for (c <- w.toCharArray) {
                val i = c - 'a'
                if (p.children(i) == null) {
                    p.children(i) = new TrieNode()
                }
                p = p.children(i)
            }
            p.word = w
        }
        root
    }
}

class TrieNode {
    val children: Array[TrieNode] = Array.ofDim[TrieNode](26)
    var word: String = ""
}